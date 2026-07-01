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
    private String applicantId;
    private String uploadedById;
    private String derivativeStatus;
}
