package constants;

import java.util.Arrays;
import java.util.List;

public class SeverityTestCase {
    public static List<String> getSeverity(){
        return Arrays.asList("Not set", "Blocker", "Critical", "Major", "Normal", "Minor", "Trivial");
    }
}