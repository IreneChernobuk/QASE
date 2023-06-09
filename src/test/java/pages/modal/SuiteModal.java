package pages.modal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuiteModal {
    private String suiteName;
    private String description;
    private String preconditions;
}