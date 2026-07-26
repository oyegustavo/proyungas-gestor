package ar.org.proyungas.application.vectoriallayer.update;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.VectorialLayer;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VectorialLayerUpdateMapper {
	VectorialLayer toDomain(VectorialLayerUpdateCommand command);
}
