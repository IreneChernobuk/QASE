package data;


import pages.modal.DefectsModal;
import utils.FakerMessageGenerator;
import utils.GenerateTestData;

public class PrepareDefectData {
    public static DefectsModal getValidDefectData() {
        return DefectsModal
                .builder()
                .defectTitle(FakerMessageGenerator.generateTitle())
                .actualResult(FakerMessageGenerator.generateText())
                .severity(GenerateTestData.getSeverity())
                .build();
    }
}