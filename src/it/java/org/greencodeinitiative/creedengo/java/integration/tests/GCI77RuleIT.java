package org.greencodeinitiative.creedengo.java.integration.tests;

import org.junit.jupiter.api.Test;

class GCI77RuleIT extends GCIRulesBase {

    @Test
    void testGCI77_invalid() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidRegexPatternNotStatic.java";
        int[] startLines = new int[]{8};
        int[] endLines = new int[]{8};
        String ruleId = "creedengo-java:GCI77";
        String ruleMsg = "Avoid using Pattern.compile() in a non-static context.";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines, SEVERITY, TYPE, EFFORT_20MIN);

    }

    @Test
    void testGCI77_valid1() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidRegexPatternNotStaticValid1.java";
        int[] startLines = new int[]{};
        int[] endLines = new int[]{};
        String ruleId = "creedengo-java:GCI77";
        String ruleMsg = "Avoid using Pattern.compile() in a non-static context.";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines, SEVERITY, TYPE, EFFORT_20MIN);

    }

    @Test
    void testGCI77_valid2() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidRegexPatternNotStaticValid2.java";
        int[] startLines = new int[]{};
        int[] endLines = new int[]{};
        String ruleId = "creedengo-java:GCI77";
        String ruleMsg = "Avoid using Pattern.compile() in a non-static context.";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines, SEVERITY, TYPE, EFFORT_20MIN);

    }

    @Test
    void testGCI77_valid3() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidRegexPatternNotStaticValid3.java";
        int[] startLines = new int[]{};
        int[] endLines = new int[]{};
        String ruleId = "creedengo-java:GCI77";
        String ruleMsg = "Avoid using Pattern.compile() in a non-static context.";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines, SEVERITY, TYPE, EFFORT_20MIN);

    }

}
