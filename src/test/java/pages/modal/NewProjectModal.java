package pages.modal;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NewProjectModal {
    private String projectName;
    private String projectCode;
    private String description;
}