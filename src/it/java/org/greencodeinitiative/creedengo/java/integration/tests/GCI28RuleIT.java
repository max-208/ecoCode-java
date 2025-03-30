package org.greencodeinitiative.creedengo.java.integration.tests;

import org.junit.jupiter.api.Test;

class GCI28RuleIT extends GCIRulesBase {

    @Test
    void testGCI28() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/OptimizeReadFileExceptionCheck.java";

        int[] startLines = new int[]{23};

        int[] endLines = new int[]{23};

        String ruleId = "creedengo-java:GCI28";
        String ruleMsg = "Optimize Read File Exceptions";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);

    }

    @Test
    void testGCI28_2() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/OptimizeReadFileExceptionCheck2.java";

        int[] startLines = new int[]{20};

        int[] endLines = new int[]{20};

        String ruleId = "creedengo-java:GCI28";
        String ruleMsg = "Optimize Read File Exceptions";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);

    }

    @Test
    void testGCI28_3() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/OptimizeReadFileExceptionCheck3.java";

        int[] startLines = new int[]{19};

        int[] endLines = new int[]{19};

        String ruleId = "creedengo-java:GCI28";
        String ruleMsg = "Optimize Read File Exceptions";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);

    }

    @Test
    void testGCI28_4() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/OptimizeReadFileExceptionCheck4.java";

        int[] startLines = new int[]{18};

        int[] endLines = new int[]{18};

        String ruleId = "creedengo-java:GCI28";
        String ruleMsg = "Optimize Read File Exceptions";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);

    }

    @Test
    void testGCI28_5() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/OptimizeReadFileExceptionCheck5.java";

        int[] startLines = new int[]{18};

        int[] endLines = new int[]{18};

        String ruleId = "creedengo-java:GCI28";
        String ruleMsg = "Optimize Read File Exceptions";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);

    }

}
