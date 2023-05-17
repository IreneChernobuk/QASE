package apitests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Model {
    private String title;
    private String code;
    private String description;
    private Integer severity;
    private Integer priority;
}