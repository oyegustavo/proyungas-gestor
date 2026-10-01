package ar.org.proyungas.application.plantype.update;

import java.net.InetAddress;
import java.util.UUID;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.AuditLog;
import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.domain.output.action.AuditLogOutputPort;
import ar.org.proyungas.domain.output.plantype.PlanTypeByIdFinderOutputPort;
import ar.org.proyungas.domain.output.plantype.PlanTypeUpdateOutputPort;
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
public class PlanTypeUpdateUseCase implements PlanTypeUpdater{
	
    private final PlanTypeUpdateOutputPort outputPort;
    private final AuditLogOutputPort auditLogOutputPort;
    private final PlanTypeByIdFinderOutputPort planTypeByIdFinderOutputPort;
    private final JsonSerializerUtils jsonSerializerUtils;

	@Override
	public void perform(PlanTypeUpdateCommand command, UUID planTypeId, HttpServletRequest request) {
		log.info("Starting perform PlanTypeUpdateUseCase with data: {}", command);
		
		PlanType existingPlanType = planTypeByIdFinderOutputPort.perform(planTypeId);
		PlanType updatedPlanType = buildPlanType(command, existingPlanType);
		
		outputPort.perform(updatedPlanType);
		
        String previousJson = jsonSerializerUtils.toJson(existingPlanType);
        String newJson = jsonSerializerUtils.toJson(updatedPlanType);
        InetAddress inetAddress = null;
        try {
        	inetAddress = InetAddress.getByName(request.getRemoteAddr());
		} catch (Exception e) {
			log.error("Inet Adrress Error", e);
			throw new InetAddressException(ErrorCode.INET_ADDRESS_ERROR);
		}
        
        AuditLog auditLog = AuditLog.builder()
                .username(CurrentUserUtils.getUsername(request))
                .actionType("UPDATE")
                .entityType("PlanType")
                .entityId(existingPlanType.getId())
                .previousState(previousJson)
                .newState(newJson)
                .clientIp(inetAddress)
                .userAgent(request.getHeader("User-Agent"))
                .build();

        auditLogOutputPort.perform(auditLog);
		
	}
	
	private PlanType buildPlanType(PlanTypeUpdateCommand command, PlanType existingPlanType) {
		
		return existingPlanType
				.withName(command.getName())
				.withEnabled(command.getEnabled());
	}
	
}
