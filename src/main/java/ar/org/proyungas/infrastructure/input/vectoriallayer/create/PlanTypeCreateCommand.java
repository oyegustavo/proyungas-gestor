package ar.org.proyungas.infrastructure.input.vectoriallayer.create;

import java.time.LocalDateTime;

public class PlanTypeCreateCommand {
    String code;
    String name;
    String group;
    String description;
    Boolean enabled;
    LocalDateTime dateFrom;
    LocalDateTime dateTo;
}
