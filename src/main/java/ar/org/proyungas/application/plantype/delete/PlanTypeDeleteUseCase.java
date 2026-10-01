package ar.org.proyungas.application.plantype.delete;

import java.net.InetAddress;
import java.util.UUID;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.AuditLog;
import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.domain.output.action.AuditLogOutputPort;
import ar.org.proyungas.domain.output.plantype.PlanTypeByIdFinderOutputPort;
import ar.org.proyungas.domain.output.plantype.PlanTypeDeleterOutputPort;
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
public class PlanTypeDeleteUseCase implements PlanTypeDeleter{

    private final PlanTypeDeleterOutputPort outputPort;
    private final AuditLogOutputPort auditLogOutputPort;
    private final PlanTypeByIdFinderOutputPort planTypeByIdFinderOutputPort;
    private final JsonSerializerUtils jsonSerializerUtils;
	
	@Override
	public void perform(UUID planTypeId, HttpServletRequest request, String deleteReason) {
		log.info("Starting perform PlanTypeDeleteUseCase with data: {}", planTypeId);
		
		PlanType deletedPlanType = planTypeByIdFinderOutputPort.perform(planTypeId);
		String previousJson = jsonSerializerUtils.toJson(deletedPlanType);
		outputPort.perform(deletedPlanType);
		
        InetAddress inetAddress = null;
        try {
        	inetAddress = InetAddress.getByName(request.getRemoteAddr());
		} catch (Exception e) {
			log.error("Inet Adrress Error", e);
			throw new InetAddressException(ErrorCode.INET_ADDRESS_ERROR);
		}
        
        AuditLog auditLog = AuditLog.builder()
                .username(CurrentUserUtils.getUsername(request))
                .actionType("DELETE")
                .entityType("PlanType")
                .entityId(deletedPlanType.getId())
                .previousState(previousJson)
                .newState(deleteReason)
                .clientIp(inetAddress)
                .userAgent(request.getHeader("User-Agent"))
                .build();

        auditLogOutputPort.perform(auditLog);
		
	}

}
