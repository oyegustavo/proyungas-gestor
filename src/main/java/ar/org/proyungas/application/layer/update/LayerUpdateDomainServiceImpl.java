package ar.org.proyungas.application.layer.update;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.org.proyungas.application.vectoriallayer.update.VectorialLayerUpdater;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class LayerUpdateDomainServiceImpl implements LayerUpdateDomainService{
	
	private final VectorialLayerUpdater vectorialLayerUpdater;

	@Override
	public void perform(List<LayerUpdaterDomainServiceCommand> commands, HttpServletRequest request) {
        log.info("Start performing LayerUpdateDomainServiceImpl with data: {}", commands);
        for (LayerUpdaterDomainServiceCommand layerUpdaterDomainServiceCommand : commands) {
        	vectorialLayerUpdater.perform(layerUpdaterDomainServiceCommand.getCommand(), layerUpdaterDomainServiceCommand.getId(), request);
		}
	}

}
