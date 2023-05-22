package apitests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DefectModal {
    private String title;
    private String actual_result;
    private Integer severity;
    private Integer milestone_id;
}