package ar.org.proyungas.application.action.create;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanTypeCreateCommand {
    private String code;
    private String name;
    private String group;
    private String description;
    private Boolean enabled;
    private LocalDate dateFrom;
    private LocalDate dateTo;
}