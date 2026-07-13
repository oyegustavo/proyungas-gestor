package ar.org.proyungas.application.action.create;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.output.action.ActionCreateOutputPort;
import ar.org.proyungas.shared.infrastructure.utils.CurrentUserUtils;
import ar.org.proyungas.shared.infrastructure.utils.UserInfo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class ActionCreateUseCase implements ActionCreator{
	
    private final ActionCreateMapper mapper;
    private final ActionCreateOutputPort outputPort;

	@Override
	public ActionCreateResult perform(ActionCreateCommand command,  HttpServletRequest request) {
        log.info("Start performing ActionCreateUseCase with data: {}", command);
        UserInfo userInfo = CurrentUserUtils.getUserInfo(request);
        Action action = mapper.toDomain(command).withApplicantId(userInfo.getUsername());
        return mapper.toResult(outputPort.perform(action));
	}

}
