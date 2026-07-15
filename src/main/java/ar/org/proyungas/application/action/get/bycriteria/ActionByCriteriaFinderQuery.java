package ar.org.proyungas.application.action.get.bycriteria;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ActionByCriteriaFinderQuery {
    private int size;
    private int page;
    private Map<String, String> filters;
}
