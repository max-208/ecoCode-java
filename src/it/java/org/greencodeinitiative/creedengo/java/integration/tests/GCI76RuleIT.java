package org.greencodeinitiative.creedengo.java.integration.tests;

import org.junit.jupiter.api.Test;

class GCI76RuleIT extends GCIRulesBase {

    @Test
    void testGCI76() {
        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidUsageOfStaticCollections.java";
        String ruleId = "creedengo-java:GCI76";
        String ruleMsg = "Avoid usage of static collections.";
        int[] startLines = new int[]{10, 12, 14};
        int[] endLines = new int[]{10, 12, 14};

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines, SEVERITY, TYPE, EFFORT_20MIN);
    }

    @Test
    void testGCI76_good() {
        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidUsageOfStaticCollectionsGoodWay.java";
        String ruleId = "creedengo-java:GCI76";
        String ruleMsg = "Avoid usage of static collections.";
        int[] startLines = new int[]{};
        int[] endLines = new int[]{};

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines, SEVERITY, TYPE, EFFORT_20MIN);
    }

}
