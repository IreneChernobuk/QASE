package data;

import pages.modal.SuiteModal;
import utils.FakerMessageGenerator;

public class PrepareSuiteData {
    public static SuiteModal getValidSuiteData(){
        return SuiteModal.builder()
                .suiteName(FakerMessageGenerator.generateTitle())
                .description(FakerMessageGenerator.generateText())
                .preconditions(FakerMessageGenerator.generateText())
                .build();
    }
}