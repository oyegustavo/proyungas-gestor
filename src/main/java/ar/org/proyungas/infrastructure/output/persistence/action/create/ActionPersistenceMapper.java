package ar.org.proyungas.infrastructure.output.persistence.action.create;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.infrastructure.output.persistence.actionlayer.create.ActionLayerMapper;
import ar.org.proyungas.infrastructure.output.persistence.emailnotification.create.EmailNotificationMapper;
import ar.org.proyungas.infrastructure.output.persistence.entities.ActionEntity;
import ar.org.proyungas.infrastructure.output.persistence.plantype.create.PlanTypeMapper;
import ar.org.proyungas.infrastructure.output.persistence.vectoriallayer.create.VectorialLayerMapper;

@Mapper(componentModel = "spring", uses = {
	    ActionLayerMapper.class,
	    EmailNotificationMapper.class,
	    VectorialLayerMapper.class,
	    PlanTypeMapper.class 
	}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
	public interface ActionPersistenceMapper {
	    Action toDomain(ActionEntity entity);
	    ActionEntity toEntity(Action action);
	    
	    List<Action> toDomain(List<ActionEntity> entities);
	    List<ActionEntity> toEntity(List<Action> actions);
	}
