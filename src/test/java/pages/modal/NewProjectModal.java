package pages.modal;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
@Getter
public class NewProjectModal {
    private String projectName;
    private String projectCode;
    private String description;
}