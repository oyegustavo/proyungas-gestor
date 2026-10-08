package ar.org.proyungas.application.layertemplate.create;

import java.net.InetAddress;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.AuditLog;
import ar.org.proyungas.domain.models.LayerTemplate;
import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.domain.output.action.AuditLogOutputPort;
import ar.org.proyungas.domain.output.layertemplate.LayerTemplateCreateOutputPort;
import ar.org.proyungas.domain.output.plantype.PlanTypeByIdFinderOutputPort;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.InetAddressException;
import ar.org.proyungas.shared.infrastructure.utils.CurrentUserUtils;
import ar.org.proyungas.shared.infrastructure.utils.JsonSerializerUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class LayerTemplateCreateUseCase implements LayerTemplateCreator{
	
    private final LayerTemplateCreateMapper mapper;
    private final LayerTemplateCreateOutputPort outputPort;
    private final AuditLogOutputPort auditLogOutputPort;
    private final JsonSerializerUtils jsonSerializerUtils;
    private final PlanTypeByIdFinderOutputPort planTypeByIdFinderOutputPort;
	@Override
	public LayerTemplateCreateResult perform(LayerTemplateCreateCommand command, HttpServletRequest request) {

        log.info("Starting perform LayerTemplateCreateUseCase with data: {}", command);
        
        PlanType planType = planTypeByIdFinderOutputPort.perform(command.getPlanType().getId());
        
        LayerTemplate layerTemplate = outputPort.perform(mapper.toDomain(command)).withPlanType(planType);
        
        String previousJson = jsonSerializerUtils.toJson(layerTemplate);
        
        InetAddress inetAddress = null;
        try {
        	inetAddress = InetAddress.getByName(request.getRemoteAddr());
		} catch (Exception e) {
			log.error("Inet Adrress Error", e);
			throw new InetAddressException(ErrorCode.INET_ADDRESS_ERROR);
		}
        
        AuditLog auditLog = AuditLog.builder()
                .username(CurrentUserUtils.getUsername(request))
                .actionType("CREATED")
                .entityType("Layer Template")
                .entityId(layerTemplate.getId())
                .previousState(previousJson)
                .newState("CREATED")
                .clientIp(inetAddress)
                .userAgent(request.getHeader("User-Agent"))
                .build();

        auditLogOutputPort.perform(auditLog);
		
        
        return mapper.toResult(outputPort.perform(mapper.toDomain(command)));
	}

}
