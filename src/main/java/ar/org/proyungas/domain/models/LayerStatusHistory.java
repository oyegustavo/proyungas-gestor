package ar.org.proyungas.domain.models;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class LayerStatusHistory {
    UUID id;
    LayerTemplate layerTemplate;
    String previousState;
    String newState;
    String action;
    String userId;
    String observation;
    LayerVersion layerVersion;
}
