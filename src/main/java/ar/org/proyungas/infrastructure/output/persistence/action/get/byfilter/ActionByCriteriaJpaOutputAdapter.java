package ar.org.proyungas.infrastructure.output.persistence.action.get.byfilter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.output.action.ActionByCriteriaFinderOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.entities.ActionEntity;
import ar.org.proyungas.infrastructure.output.persistence.repository.ActionRepository;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.InvalidFilterException;
import ar.org.proyungas.shared.infrastructure.utils.Filter;
import ar.org.proyungas.shared.infrastructure.utils.JpaFilter;
import ar.org.proyungas.shared.infrastructure.utils.JpaFilterBuilder;
import ar.org.proyungas.shared.infrastructure.utils.PageDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class ActionByCriteriaJpaOutputAdapter implements ActionByCriteriaFinderOutputPort{

    private final ActionRepository repository;
    private final ActionByCriteriaJpaMapper mapper;
    private static final String DEFAULT_ORDER_COLUMN = "propertyOwner";
	
	@Override
	public PageDomain<Action> perform(Integer page, Integer size, List<Filter> filters) {
        try {
            log.info("Searching users by filters {}, page {} and size {}", filters, page, size);

            List<JpaFilter> jpaFilters = buildJpaFilters(filters);
            Specification<ActionEntity> specification = getFiltersSpecification(jpaFilters);
            Page<ActionEntity> pageEntity = repository.findAll(
            	    specification,
            	    PageRequest.of(page - 1, size, buildSort())
            	);

            return PageDomain.<Action>builder()
                    .content(pageEntity.getContent().stream().map(mapper::toDomain).collect(Collectors.toList()))
                    .number(pageEntity.getNumber())
                    .size(pageEntity.getSize())
                    .totalPages(pageEntity.getTotalPages())
                    .totalElements(pageEntity.getTotalElements())
                    .build();
        } catch (InvalidDataAccessApiUsageException ex) {
            log.error("Error on data type usage on database", ex);
            throw new InvalidFilterException(ErrorCode.INVALID_FILTER);
        } catch (DataAccessException ex) {
            log.error("Error executing query to database", ex);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}
	
    private List<JpaFilter> buildJpaFilters(List<Filter> filters) {
        JpaFilterBuilder builder = new JpaFilterBuilder();

        return filters.stream().map(builder::build)
                .collect(Collectors.toList());
    }
	
	
    private Specification<ActionEntity> getFiltersSpecification(List<JpaFilter> filters) {
        if (filters.isEmpty()) return null;

        Specification<ActionEntity> specification = filters.get(0).getSpecification();
        filters.remove(0);

        for (JpaFilter filter : filters) {
            specification = specification.and(filter.getSpecification());
        }

        return specification;
    }


    private Sort buildSort() {
        return Sort.by(Sort.Direction.ASC, DEFAULT_ORDER_COLUMN);
    }


}
