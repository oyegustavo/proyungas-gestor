package ar.org.proyungas.application.vectoriallayer.create;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.output.action.VectorialLayerCreateOutputPort;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class VectorialLayerCreateUseCase implements VectorialLayerCreator{

    private final VectorialLayerCreateMapper mapper;
    private final VectorialLayerCreateOutputPort outputPort;
	
	@Override
	public VectorialLayerCreateResult perform(VectorialLayerCreateCommand command, HttpServletRequest request) {
        log.info("Start performing VectorialLayerCreateUseCase with data: {}", command);
		return mapper.toResult(outputPort.perform(mapper.toDomain(command)));
	}
}
