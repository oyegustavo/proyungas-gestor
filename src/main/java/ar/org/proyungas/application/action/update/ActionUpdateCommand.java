package ar.org.proyungas.application.action.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionUpdateCommand {
    private Integer applicantId;
    private Integer uploadedById;
    private String derivativeStatus;
}
