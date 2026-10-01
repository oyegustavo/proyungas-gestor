package ar.org.proyungas.application.plantype.create;

import java.net.InetAddress;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.AuditLog;
import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.domain.output.action.AuditLogOutputPort;
import ar.org.proyungas.domain.output.plantype.PlanTypeCreateOutputPort;
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
public class PlanTypeCreateUseCase implements PlanTypeCreator{

    private final PlanTypeCreateMapper mapper;
    private final PlanTypeCreateOutputPort outputPort;
    private final AuditLogOutputPort auditLogOutputPort;
    private final JsonSerializerUtils jsonSerializerUtils;
	
	@Override
	public PlanTypeCreateResult perform(PlanTypeCreateCommand command, HttpServletRequest request) {
        log.info("Starting perform PlanTypeCreateUseCase with data: {}", command);
        
        PlanType planType = outputPort.perform(mapper.toDomain(command));
        
        String previousJson = jsonSerializerUtils.toJson(planType);
        
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
                .entityType("PlanType")
                .entityId(planType.getId())
                .previousState(previousJson)
                .newState("CREATED")
                .clientIp(inetAddress)
                .userAgent(request.getHeader("User-Agent"))
                .build();

        auditLogOutputPort.perform(auditLog);
		
        
        return mapper.toResult(outputPort.perform(mapper.toDomain(command)));
	}
}
