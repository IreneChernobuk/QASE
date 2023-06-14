package pages.modal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DefectsModal {
    private String defectTitle;
    private String actualResult;
    private String severity;
}