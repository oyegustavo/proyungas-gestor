package ar.org.proyungas.infrastructure.input.layer.update;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.application.layer.update.LayerUpdaterDomainServiceCommand;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LayerUpdateRestMapper {
	List<LayerUpdaterDomainServiceCommand> toCommand(List<LayerUpdateRequest> request);
}
