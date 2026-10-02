package ar.org.proyungas.application.plantype.get.bycriteria;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PlanTypeByCriteriaFinderQuery {
    private int size;
    private int page;
    private Map<String, String> filters;
}
