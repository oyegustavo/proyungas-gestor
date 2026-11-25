package ar.org.proyungas.application.plantype.get.info;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.LayerTemplate;
import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.domain.output.plantype.PlanTypeByEnabledFinderOutputPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class PlanTypeGetInfoUseCase implements PlanTypeGetInfoFinder {

    private final PlanTypeByEnabledFinderOutputPort outputPort;
    private final PlanTypeGetInfoMapper mapper;

    @Override
    public PlanTypeInfoResult perform() {

        log.info("Starting perform PlanTypeGetInfoUseCase");

        List<PlanType> enabledPlanTypes =
        		outputPort.perform(true);

        List<PlanType> disabledPlanTypes =
        		outputPort.perform(false);

        List<LayerTemplate> layers = enabledPlanTypes.stream()
                .filter(planType -> planType.getLayers() != null)
                .flatMap(planType -> planType.getLayers().stream())
                .toList();

        int requiredLayerCounter = (int) layers.stream()
                .filter(LayerTemplate::getRequired)
                .count();
        
        return mapper.toResult(
        		PlanTypeInfoDto.builder()
                .enabledPlanTypeCounter(enabledPlanTypes.size())
                .disabledPlanTypeCounter(disabledPlanTypes.size())
                .planTypeLayerCounter(layers.size())
                .requiredPlanTypeLayerCounter(requiredLayerCounter)
                .build());
    }
}
