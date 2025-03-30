package org.greencodeinitiative.creedengo.java.integration.tests;

import org.junit.jupiter.api.Test;

class GCI1RuleIT extends GCIRulesBase {

    @Test
    void testGCI1_loop() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidSpringRepositoryCallInLoopCheck.java";

        int[] startLines = new int[]{32};

        int[] endLines = new int[]{32};

        String ruleId = "creedengo-java:GCI1";
        String ruleMsg = "Avoid Spring repository call in loop or stream";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines, SEVERITY, TYPE, EFFORT_50MIN);

    }

    @Test
    void testGCI1_stream() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidSpringRepositoryCallInStreamCheck.java";

        int[] startLines = new int[]{36, 46, 56, 66, 76, 84, 96, 105};

        int[] endLines = new int[]{36, 46, 56, 66, 76, 84, 96, 105};

        String ruleId = "creedengo-java:GCI1";
        String ruleMsg = "Avoid Spring repository call in loop or stream";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines, SEVERITY, TYPE, EFFORT_50MIN);

    }

}
