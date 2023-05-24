package constants;

import java.util.Arrays;
import java.util.List;

public class TypeTestCase {
    public static List<String> getType() {
        return Arrays.asList("Other",
                "Functional",
                "Smoke",
                "Regression",
                "Security",
                "Usability",
                "Performance",
                "Acceptance",
                "Compatibility",
                "Integration",
                "Exploratory");
    }
}