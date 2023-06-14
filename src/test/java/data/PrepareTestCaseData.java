package data;

import pages.modal.TestCaseModal;
import utils.FakerMessageGenerator;
import utils.GenerateTestData;

public class PrepareTestCaseData {
    public static TestCaseModal detValidData(){
        return TestCaseModal.builder()
                .title(FakerMessageGenerator.generateTitle())
                .description(FakerMessageGenerator.generateText())
                .preConditions(FakerMessageGenerator.generateText())
                .postConditions(FakerMessageGenerator.generateText())
                .severity(GenerateTestData.getSeverity())
                .priority(GenerateTestData.getPriority())
                .status(GenerateTestData.getStatus())
                .type(GenerateTestData.getType())
                .layer(GenerateTestData.getLayer())
                .isFlaky(GenerateTestData.getIsFlaky())
                .behavior(GenerateTestData.getBehavior())
                .automationStatus(GenerateTestData.getAutomationStatus())
                .stepAction(FakerMessageGenerator.generateText())
                .stepData(FakerMessageGenerator.generateText())
                .expectedResult(FakerMessageGenerator.generateText())
                .build();
    }
}