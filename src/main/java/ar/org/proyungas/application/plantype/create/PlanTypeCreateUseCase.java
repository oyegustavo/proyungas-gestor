package ar.org.proyungas.application.plantype.create;

import java.net.InetAddress;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ar.org.proyungas.domain.models.AuditLog;
import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.domain.models.PlanTypeHistory;
import ar.org.proyungas.domain.models.User;
import ar.org.proyungas.domain.output.action.AuditLogOutputPort;
import ar.org.proyungas.domain.output.plantype.PlanTypeCreateOutputPort;
import ar.org.proyungas.domain.output.plantypehistory.PlanTypeHistoryOutputPort;
import ar.org.proyungas.domain.output.user.UserByUsernameOutputPort;
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
@Transactional
public class PlanTypeCreateUseCase implements PlanTypeCreator{

    private final PlanTypeCreateMapper mapper;
    private final PlanTypeCreateOutputPort outputPort;
    private final AuditLogOutputPort auditLogOutputPort;
    private final JsonSerializerUtils jsonSerializerUtils;
    private final PlanTypeHistoryOutputPort planTypeHistoryOutputPort;
    private final UserByUsernameOutputPort userByUsernameOutputPort;
	
	@Override
	public PlanTypeCreateResult perform(PlanTypeCreateCommand command, HttpServletRequest request) {
		String username = CurrentUserUtils.getUsername(request);
        log.info("Starting perform PlanTypeCreateUseCase with data: {} - user: {}", command, username);
        User user = userByUsernameOutputPort.peform(username);
        PlanType planType = outputPort.perform(mapper.toDomain(command));
        
        InetAddress inetAddress = null;
        try {
        	inetAddress = InetAddress.getByName(request.getRemoteAddr());
		} catch (Exception e) {
			log.error("Inet Adrress Error", e);
			throw new InetAddressException(ErrorCode.INET_ADDRESS_ERROR);
		}
        
        AuditLog auditLog = AuditLog.builder()
                .username(username)
                .actionType("CREATED")
                .entityType("PlanType")
                .entityId(planType.getId())
                .previousState("{}")
                .newState(jsonSerializerUtils.toJson(planType))
                .clientIp(inetAddress)
                .userAgent(request.getHeader("User-Agent"))
                .build();

        auditLogOutputPort.perform(auditLog);
        
        PlanTypeHistory planTypeHistory = PlanTypeHistory.builder()
        		.action("CREATED")
        		.comments(command.getComments())
        		.planType(planType)
        		.user(user)
        		.build();
        
        planTypeHistoryOutputPort.perform(planTypeHistory);
		
        
        return mapper.toResult(planType);
	}
}
