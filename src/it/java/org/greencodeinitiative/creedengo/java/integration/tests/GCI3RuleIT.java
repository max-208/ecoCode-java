package org.greencodeinitiative.creedengo.java.integration.tests;

import org.junit.jupiter.api.Test;

class GCI3RuleIT extends GCIRulesBase {

    @Test
    void testGCI3_forEachLoopIgnored() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidGettingSizeCollectionInForEachLoopIgnored.java";
        int[] startLines = new int[]{};
        int[] endLines = new int[]{};
        String ruleId = "creedengo-java:GCI3";
        String ruleMsg = "Avoid getting the size of the collection in the loop";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);

    }

    @Test
    void testGCI3_forLoopBad() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidGettingSizeCollectionInForLoopBad.java";
        int[] startLines = new int[]{13};
        int[] endLines = new int[]{13};
        String ruleId = "creedengo-java:GCI3";
        String ruleMsg = "Avoid getting the size of the collection in the loop";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);

    }

    @Test
    void testGCI3_forEachLoopGood() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidGettingSizeCollectionInForLoopGood.java";
        int[] startLines = new int[]{};
        int[] endLines = new int[]{};
        String ruleId = "creedengo-java:GCI3";
        String ruleMsg = "Avoid getting the size of the collection in the loop";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);

    }

    @Test
    void testGCI3_forLoopIgnored() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidGettingSizeCollectionInForLoopIgnored.java";
        int[] startLines = new int[]{};
        int[] endLines = new int[]{};
        String ruleId = "creedengo-java:GCI3";
        String ruleMsg = "Avoid getting the size of the collection in the loop";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);

    }

    @Test
    void testGCI3_whileLoopBad() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidGettingSizeCollectionInWhileLoopBad.java";
        int[] startLines = new int[]{17};
        int[] endLines = new int[]{17};
        String ruleId = "creedengo-java:GCI3";
        String ruleMsg = "Avoid getting the size of the collection in the loop";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);

    }

    @Test
    void testGCI3_whileLoopGood() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidGettingSizeCollectionInWhileLoopGood.java";
        int[] startLines = new int[]{};
        int[] endLines = new int[]{};
        String ruleId = "creedengo-java:GCI3";
        String ruleMsg = "Avoid getting the size of the collection in the loop";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);

    }

    @Test
    void testGCI3_whileLoopIgnored() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidGettingSizeCollectionInWhileLoopIgnored.java";
        int[] startLines = new int[]{};
        int[] endLines = new int[]{};
        String ruleId = "creedengo-java:GCI3";
        String ruleMsg = "Avoid getting the size of the collection in the loop";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);

    }

}
