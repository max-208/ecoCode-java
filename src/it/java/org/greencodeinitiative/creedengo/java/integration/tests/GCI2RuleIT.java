package org.greencodeinitiative.creedengo.java.integration.tests;

import org.junit.jupiter.api.Test;

class GCI2RuleIT extends GCIRulesBase {

    @Test
    void testGCI2() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidMultipleIfElseStatement.java";

        int[] startLines = new int[]{
                24, 43, 45, 71, 88, 110,
                112, 131, 135, 137, 158, 164,
                190, 209, 212, 214, 211, 236,
                257, 259
        };

        int[] endLines = new int[]{
                24, 43, 47, 71, 90, 110,
                114, 133, 135, 139, 160, 166,
                192, 209, 212, 216, 217, 238,
                257, 261
        };

        String ruleId = "creedengo-java:GCI2";
        String ruleMsg = "Use a switch statement instead of multiple if-else if possible";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);

    }

    @Test
    void testGCI2_compareMethodNoIssue() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidMultipleIfElseStatementCompareMethodNoIssue.java";

        int[] startLines = new int[]{};

        int[] endLines = new int[]{};

        String ruleId = "creedengo-java:GCI2";
        String ruleMsg = "Use a switch statement instead of multiple if-else if possible";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);

    }

    @Test
    void testGCI2_interfaceNoIssue() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidMultipleIfElseStatementInterfaceNoIssue.java";

        int[] startLines = new int[]{};

        int[] endLines = new int[]{};

        String ruleId = "creedengo-java:GCI2";
        String ruleMsg = "Use a switch statement instead of multiple if-else if possible";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);

    }

    @Test
    void testGCI2_noBlockNoIssue() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidMultipleIfElseStatementNoBlockNoIssue.java";

        int[] startLines = new int[]{};

        int[] endLines = new int[]{};

        String ruleId = "creedengo-java:GCI2";
        String ruleMsg = "Use a switch statement instead of multiple if-else if possible";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);

    }

    @Test
    void testGCI2_noIssue() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidMultipleIfElseStatementNoIssue.java";

        int[] startLines = new int[]{};

        int[] endLines = new int[]{};

        String ruleId = "creedengo-java:GCI2";
        String ruleMsg = "Use a switch statement instead of multiple if-else if possible";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);

    }

}
