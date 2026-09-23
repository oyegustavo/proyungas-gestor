package ar.org.proyungas.application.user.get.byusername;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.output.user.UserByUsernameOutputPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserByUsernameFinderUseCase implements UserByUsernameFinder {

    private final UserByUsernameOutputPort outputPort;
    private final UserByUsernameFinderMapper mapper;

    @Override
    public UserByUsernameFinderResult perform(String username) {
        return mapper.toResult(outputPort.peform(username));
	}
}