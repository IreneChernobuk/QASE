package constants;

import lombok.Data;

public enum ProjectName {
    QASE("QASE"),
    SHARELANE("SHARELANE");

    private final String projectName;

    ProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }
}