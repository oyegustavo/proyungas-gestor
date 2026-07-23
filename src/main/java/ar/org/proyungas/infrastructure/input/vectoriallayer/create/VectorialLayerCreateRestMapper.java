package ar.org.proyungas.infrastructure.input.vectoriallayer.create;

import org.mapstruct.Mapper;

import ar.org.proyungas.application.vectoriallayer.create.VectorialLayerCreateCommand;
import ar.org.proyungas.application.vectoriallayer.create.VectorialLayerCreateResult;

@Mapper(componentModel = "spring")
public interface VectorialLayerCreateRestMapper {
	VectorialLayerCreateCommand toCommand(VectorialLayerCreateRequest request);
	VectorialLayerCreateResponse toResponse(VectorialLayerCreateResult result);
}
