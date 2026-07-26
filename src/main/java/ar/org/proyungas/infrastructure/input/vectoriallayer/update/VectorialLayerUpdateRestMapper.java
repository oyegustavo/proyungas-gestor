package ar.org.proyungas.infrastructure.input.vectoriallayer.update;

import org.mapstruct.Mapper;

import ar.org.proyungas.application.vectoriallayer.update.VectorialLayerUpdateCommand;

@Mapper(componentModel = "spring")
public interface VectorialLayerUpdateRestMapper {
	VectorialLayerUpdateCommand toCommand(VectorialLayerUpdateRequest request);
}
