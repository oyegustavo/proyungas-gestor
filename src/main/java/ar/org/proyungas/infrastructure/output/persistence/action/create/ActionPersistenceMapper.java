package ar.org.proyungas.infrastructure.output.persistence.action.create;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.models.LayerTemplate;
import ar.org.proyungas.domain.models.LayerVersion;
import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.domain.models.User;
import ar.org.proyungas.domain.models.VectorialLayer;
import ar.org.proyungas.infrastructure.output.persistence.entities.ActionEntity;
import ar.org.proyungas.infrastructure.output.persistence.entities.LayerTemplateEntity;
import ar.org.proyungas.infrastructure.output.persistence.entities.LayerVersionEntity;
import ar.org.proyungas.infrastructure.output.persistence.entities.PlanTypeEntity;
import ar.org.proyungas.infrastructure.output.persistence.entities.UserEntity;
import ar.org.proyungas.infrastructure.output.persistence.entities.VectorialLayerEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActionPersistenceMapper {

    @Mapping(target = "emailNotifications", ignore = true)
    @Mapping(target = "planType", expression = "java(toPlanType(entity.getPlanType()))")
    @Mapping(target = "applicant", expression = "java(toUser(entity.getApplicant()))")
    @Mapping(target = "uploadedBy", expression = "java(toUser(entity.getUploadedBy()))")
    @Mapping(target = "vectorialLayers", expression = "java(toVectorialLayers(entity.getVectorialLayers()))")
    Action toDomain(ActionEntity entity);
    
    // Add this for lists
    List<Action> toDomain(List<ActionEntity> entities);

    // If you also need reverse mapping
    List<ActionEntity> toEntity(List<Action> actions);

    // Helper to flatten PlanTypeEntity
    default PlanType toPlanType(PlanTypeEntity entity) {
        if (entity == null) return null;
        return PlanType.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .group(entity.getGroup())
                .description(entity.getDescription())
                .enabled(entity.getEnabled())
                .dateFrom(entity.getDateFrom())
                .dateTo(entity.getDateTo())
                .build();
    }

    // Helper to flatten VectorialLayerEntity list
    default Set<VectorialLayer> toVectorialLayers(Set<VectorialLayerEntity> entities) {
        if (entities == null) return null;
        return entities.stream()
                .map(this::toVectorialLayer)
                .collect(Collectors.toSet());
    }

    // Flatten VectorialLayerEntity
    default VectorialLayer toVectorialLayer(VectorialLayerEntity entity) {
        if (entity == null) return null;
        return VectorialLayer.builder()
                .id(entity.getId())
                .templateLayer(toLayerTemplate(entity.getTemplateLayer()))
                .currentStatus(entity.getCurrentStatus())
                .technicianAssigned(toUser(entity.getTechnicianAssigned()))
                .observation(entity.getObservation())
                .currentVersion(toLayerVersion(entity.getCurrentVersion()))
                .reinstatedFromOmitted(entity.getReinstatedFromOmitted())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    // Flatten LayerTemplateEntity
    default LayerTemplate toLayerTemplate(LayerTemplateEntity entity) {
        if (entity == null) return null;
        return LayerTemplate.builder()
                .id(entity.getId())
                .layerCode(entity.getLayerCode())
                .label(entity.getLabel())
                .required(entity.getRequired())
                .order(entity.getOrder())
                .description(entity.getDescription())
                .active(entity.getActive())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    // Flatten LayerVersionEntity
    default LayerVersion toLayerVersion(LayerVersionEntity entity) {
        if (entity == null) return null;
        return LayerVersion.builder()
                .id(entity.getId())
                .versionNumber(entity.getVersionNumber())
                .formatt(entity.getFormatt())
                .originalNumber(entity.getOriginalNumber())
                .minioPath(entity.getMinioPath())
                .minioBucket(entity.getMinioBucket())
                .bytesSize(entity.getBytesSize())
                .hashSha256(entity.getHashSha256())
                .coordsSystem(entity.getCoordsSystem())
                .uploadedById(toUser(entity.getUploadedById()))
                .build();
    }

    default User toUser(UserEntity entity) {
        if (entity == null) return null;
        return User.builder()
                .id(entity.getId())
                .fullname(entity.getFullname())
                .email(entity.getEmail())
                .build();
    }
}
