package ar.org.proyungas.infrastructure.input.vectoriallayer.update;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.application.vectoriallayer.update.VectorialLayerUpdateCommand;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VectorialLayerUpdateRestMapper {
	VectorialLayerUpdateCommand toCommand(VectorialLayerUpdateRequest request);
}
