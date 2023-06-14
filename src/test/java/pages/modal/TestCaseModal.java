package pages.modal;

import lombok.Builder;
import lombok.Data;
import org.openqa.selenium.By;

@Data
@Builder
public class TestCaseModal {
    private String title;
    private String status;
    private String description;
    private String severity;
    private String priority;
    private String type;
    private String layer;
    private String isFlaky;
    private String behavior;
    private String automationStatus;
    private String preConditions;
    private String postConditions;
    private String stepAction;
    private String stepData;
    private String expectedResult;
}