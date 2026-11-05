package ar.org.proyungas.infrastructure.output.persistence.action.create;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.models.EmailNotification;
import ar.org.proyungas.domain.models.LayerTemplate;
import ar.org.proyungas.domain.models.LayerVersion;
import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.domain.models.User;
import ar.org.proyungas.domain.models.VectorialLayer;
import ar.org.proyungas.infrastructure.output.persistence.entities.ActionEntity;
import ar.org.proyungas.infrastructure.output.persistence.entities.EmailNotificationEntity;
import ar.org.proyungas.infrastructure.output.persistence.entities.LayerTemplateEntity;
import ar.org.proyungas.infrastructure.output.persistence.entities.LayerVersionEntity;
import ar.org.proyungas.infrastructure.output.persistence.entities.PlanTypeEntity;
import ar.org.proyungas.infrastructure.output.persistence.entities.UserEntity;
import ar.org.proyungas.infrastructure.output.persistence.entities.VectorialLayerEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActionPersistenceMapper {

    @Mapping(target = "vectorialLayers", ignore = true)
    @Mapping(target = "emailNotifications", ignore = true)
    @Mapping(target = "planType", expression = "java(toPlanType(entity.getPlanType()))")
    @Mapping(target = "applicant", expression = "java(toUser(entity.getApplicant()))")
    @Mapping(target = "uploadedBy", expression = "java(toUser(entity.getUploadedBy()))")
    Action toDomain(ActionEntity entity);

    // Flatten PlanTypeEntity: ignore layers
    @Mapping(target = "layers", ignore = true)
    PlanType toPlanType(PlanTypeEntity entity);

    // Flatten LayerTemplateEntity: ignore planType
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


    // Flatten VectorialLayerEntity: ignore action, versions
    @Mapping(target = "action", ignore = true)
    @Mapping(target = "versions", ignore = true)
    @Mapping(target = "templateLayer", expression = "java(toLayerTemplate(entity.getTemplateLayer()))")
    @Mapping(target = "currentVersion", expression = "java(toLayerVersion(entity.getCurrentVersion()))")
    @Mapping(target = "technicianAssigned", expression = "java(toUser(entity.getTechnicianAssigned()))")
    VectorialLayer toDomain(VectorialLayerEntity entity);

    // Flatten LayerVersionEntity: ignore layer
    @Mapping(target = "uploadedById", expression = "java(toUser(entity.getUploadedById()))")
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
                .build();
    }


    // Flatten EmailNotificationEntity: ignore action, layer, layerTemplate
    @Mapping(target = "action", ignore = true)
    @Mapping(target = "layerTemplate", ignore = true)
    @Mapping(target = "recipient", expression = "java(toUser(entity.getRecipient()))")
    default EmailNotification toEmailNotification(EmailNotificationEntity entity) {
        if (entity == null) return null;
        return EmailNotification.builder()
                .id(entity.getId())
                .eventType(entity.getEventType())
                .statusSent(entity.getStatusSent())
                .attempts(entity.getAttempts())
                .celeryTaskId(entity.getCeleryTaskId())
                .createdAt(entity.getCreatedAt())
                .sentAt(entity.getSentAt())
                .build();
    }


    User toUser(UserEntity entity);
    
    // Add this: MapStruct will generate the list mapping
    List<Action> toDomain(List<ActionEntity> entities);

    // If you need reverse mapping too
    List<ActionEntity> toEntity(List<Action> actions);
}

