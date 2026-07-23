package ar.org.proyungas.application.vectoriallayer.create;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.VectorialLayer;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VectorialLayerCreateMapper {
	VectorialLayerCreateResult toResult(VectorialLayer vectorialLayer);
	VectorialLayer toDomain(VectorialLayerCreateCommand command);
}
