package ar.org.proyungas.infrastructure.output.persistence.vectoriallayer.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.VectorialLayer;
import ar.org.proyungas.infrastructure.output.persistence.entities.VectorialLayerEntity;
import ar.org.proyungas.infrastructure.output.persistence.entities.LayerVersionEntity;

import java.util.ArrayList;

@Component
public abstract class VectorialLayerMapperDecorator implements VectorialLayerMapper {

    @Autowired
    @Qualifier("delegate")
    private VectorialLayerMapper delegate;

    @Override
    public VectorialLayerEntity toEntity(VectorialLayer domain) {
        VectorialLayerEntity entity = delegate.toEntity(domain);

        LayerVersionEntity version = entity.getCurrentVersion();
        if (version != null) {
            // wire both sides
            version.setLayer(entity);
            entity.setCurrentVersion(version);

            // defensive initialization
            if (entity.getVersions() == null) {
                entity.setVersions(new ArrayList<>());
            }
            entity.getVersions().add(version);
        }

        return entity;
    }
}
