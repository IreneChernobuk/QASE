package data;

import pages.modal.NewProjectModal;
import utils.FakerMessageGenerator;

public class PrepareNewProjectData {
    public static NewProjectModal getValidProjectData() {
        return NewProjectModal
                .builder()
                .projectName(FakerMessageGenerator.generateTitle())
                .projectCode(FakerMessageGenerator.generateCodeForProject())
                .description(FakerMessageGenerator.generateText())
                .build();
    }
}