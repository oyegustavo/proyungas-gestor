package ar.org.proyungas.application.layer.update;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class LayerUpdateDomainServiceImpl implements LayerUpdateDomainService{
	
	private final LayerUpdateDomainService layerUpdateDomainService;

	@Override
	public void perform(List<LayerUpdaterDomainServiceCommand> commands, HttpServletRequest request) {
        log.info("Start performing LayerUpdateDomainServiceImpl with data: {}", commands);
        layerUpdateDomainService.perform(commands, request);
	}

}
