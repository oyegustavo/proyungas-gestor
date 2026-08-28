package ar.org.proyungas.infrastructure.input.vectoriallayerstatus.update;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.application.vectoriallayer.updatestatus.VectorialLayerStatusUpdateCommand;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VectorialLayerStatusUpdateMapper {
	VectorialLayerStatusUpdateCommand toCommand(VectorialLayerStatusUpdateRequest request);
}