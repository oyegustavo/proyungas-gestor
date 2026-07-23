package ar.org.proyungas.infrastructure.input.vectoriallayer.create;

import org.mapstruct.Mapper;

import ar.org.proyungas.application.vectoriallayer.create.ActionCommand;
import ar.org.proyungas.application.vectoriallayer.create.VectorialLayerCreateCommand;
import ar.org.proyungas.application.vectoriallayer.create.VectorialLayerCreateResult;

@Mapper(componentModel = "spring")
public interface VectorialLayerCreateRestMapper {

    VectorialLayerCreateCommand toCommand(VectorialLayerCreateRequest request);
    VectorialLayerCreateResponse toResponse(VectorialLayerCreateResult result);

    default LayerTemplateCreateCommand toCommand(LayerTemplateCreateRequest request) {
        if (request == null) return null;
        return LayerTemplateCreateCommand.builder()
                .id(request.getId())
                .build();
    }

    default ActionCommand toCommand(ActionRequest request) {
        if (request == null) return null;
        return ActionCommand.builder()
                .id(request.getId())
                .build();
    }
}

