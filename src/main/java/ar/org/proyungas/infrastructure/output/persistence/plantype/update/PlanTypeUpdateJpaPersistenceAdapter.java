package ar.org.proyungas.infrastructure.output.persistence.plantype.update;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.domain.output.plantype.PlanTypeUpdateOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.entities.PlanTypeEntity;
import ar.org.proyungas.infrastructure.output.persistence.plantype.create.PlanTypePersistenceMapper;
import ar.org.proyungas.infrastructure.output.persistence.plantype.repository.PlanTypeRepository;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.PlanTypeBadRequestException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class PlanTypeUpdateJpaPersistenceAdapter implements PlanTypeUpdateOutputPort {

    private final PlanTypePersistenceMapper mapper;
    private final PlanTypeRepository repository;

    @Override
    public void perform(PlanType planType) {
        log.info("Starting perform PlanTypeUpdateJpaPersistenceAdapter with data: {}", planType);
        try {
            PlanTypeEntity planTypeEntity = mapper.toEntity(planType);

            if (planTypeEntity.getLayers() != null) {
                planTypeEntity.getLayers().forEach(layer -> layer.setPlanType(planTypeEntity));
            }

            repository.save(planTypeEntity);

        } catch (DataIntegrityViolationException e) {
            log.error("DataIntegrityViolationException while performing PlanTypeUpdateJpaPersistenceAdapter with data {}", planType, e);
            throw new PlanTypeBadRequestException(ErrorCode.INVALID_PLAN_TYPE_ERROR);
        } catch (DataAccessException e) {
            log.error("DataAccessException while performing PlanTypeUpdateJpaPersistenceAdapter with data {}", planType, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
    }
}
