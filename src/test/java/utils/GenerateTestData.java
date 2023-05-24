package utils;

import constants.*;

import java.util.List;
import java.util.Random;

public class GenerateTestData {
    public static int getRandomIndex(int listSize) {
        Random ramdom = new Random();
        return ramdom.nextInt(listSize);
    }

    public static String getPriority() {
        List<String> priority = PriorityTestCase.getPriority();
        return priority.get(getRandomIndex(priority.size()));
    }

    public static String getSeverity() {
        List<String> severity = SeverityTestCase.getSeverity();
        return severity.get(getRandomIndex(severity.size()));
    }

    public static String getStatus() {
        List<String> status = StatusTestClass.getStatus();
        return status.get(getRandomIndex(status.size()));
    }

    public static String getType() {
        List<String> type = TypeTestCase.getType();
        return type.get(getRandomIndex(type.size()));
    }

    public static String getLayer() {
        List<String> layer = LayerTestData.getLayer();
        return layer.get(getRandomIndex(layer.size()));
    }

    public static String getIsFlaky() {
        List<String> isFlaky = IsFlakyTestCase.getIsFlaky();
        return isFlaky.get(getRandomIndex(isFlaky.size()));
    }

    public static String getBehavior() {
        List<String> behavior = BehaviorTestCase.getBehavior();
        return behavior.get(getRandomIndex(behavior.size()));
    }

    public static String getAutomationStatus() {
        List<String> autStatus = AutomationStatusTestCase.getAutomationStatus();
        return autStatus.get(getRandomIndex(autStatus.size()));
    }
    public static String getAccessTypeProject() {
        List<String> accessType = AccessTypeProject.getAccessType();
        return accessType.get(getRandomIndex(accessType.size()));
    }
}