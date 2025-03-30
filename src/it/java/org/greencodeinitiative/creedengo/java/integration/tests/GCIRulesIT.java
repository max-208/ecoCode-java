package org.greencodeinitiative.creedengo.java.integration.tests;

import org.junit.jupiter.api.Test;
import org.sonarqube.ws.Issues;
import org.sonarqube.ws.Measures;

import java.util.List;
import java.util.Map;

import static java.util.Optional.ofNullable;
import static org.assertj.core.api.Assertions.assertThat;

class GCIRulesIT extends GCIRulesBase {

    @Test
    void testMeasuresAndIssues() {
        String projectKey = analyzedProjects.get(0).getProjectKey();

        Map<String, Measures.Measure> measures = getMeasures(projectKey);

        assertThat(ofNullable(measures.get("code_smells")).map(Measures.Measure::getValue).map(Integer::parseInt).orElse(0))
                .isGreaterThan(1);

        List<Issues.Issue> projectIssues = searchIssuesForComponent(projectKey, null).getIssuesList();
        assertThat(projectIssues).isNotEmpty();

    }

    @Test
    void testGCI27() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/ArrayCopyCheck.java";
        String ruleId = "creedengo-java:GCI27";
        String ruleMsg = "Use System.arraycopy to copy arrays";
        int[] startLines = new int[]{
                51, 56, 63, 72, 85, 94,
                105, 116, 139, 145, 153, 163,
                177, 187, 199, 211, 229, 236,
                245, 256, 271, 282, 295, 308,
                334, 341, 350, 361, 376, 389,
                415, 422, 431, 442, 457, 470
        };
        int[] endLines = new int[]{
                53, 60, 69, 82, 91, 102,
                113, 124, 141, 149, 159, 173,
                183, 195, 207, 219, 232, 241,
                252, 267, 278, 291, 304, 317,
                337, 346, 357, 372, 385, 398,
                418, 427, 438, 453, 466, 479
        };

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines, SEVERITY, TYPE, EFFORT_20MIN);

    }

    @Test
    void testGCI74() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidFullSQLRequestCheck.java";
        int[] startLines = new int[]{8, 12, 17, 23};
        int[] endLines = new int[]{8, 12, 17, 23};
        String ruleId = "creedengo-java:GCI74";
        String ruleMsg = "Don't use the query SELECT * FROM";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines, SEVERITY, TYPE, EFFORT_20MIN);

    }

    @Test
    void testGCI78() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidSetConstantInBatchUpdateCheck.java";
        int[] startLines = new int[]{
                34, 35, 36, 37, 38, 39,
                40, 41, 42, 43, 44, 45,
                46, 61, 63, 64, 65, 66,
                67, 70, 86, 88, 90, 91,
                92, 93, 94, 96, 114, 116,
                117, 118, 119, 120, 121, 123
        };
        int[] endLines = new int[]{
                34, 35, 36, 37, 38, 39,
                40, 41, 42, 43, 44, 45,
                46, 61, 63, 64, 65, 66,
                67, 70, 86, 88, 90, 91,
                92, 93, 94, 96, 114, 116,
                117, 118, 119, 120, 121, 123
        };
        String ruleId = "creedengo-java:GCI78";
        String ruleMsg = "Avoid setting constants in batch update";

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines, SEVERITY, TYPE, EFFORT_15MIN);

    }

    @Test
    void testGCI72() {
        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidSQLRequestInLoopCheck.java";
        String ruleId = "creedengo-java:GCI72";
        String ruleMsg = "Avoid SQL request in loop";
        int[] startLines = new int[]{57, 88, 119};
        int[] endLines = new int[]{57, 88, 119};

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines, SEVERITY, TYPE, EFFORT_10MIN);
    }

    @Test
    void testGCI5() {
        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidStatementForDMLQueries.java";
        String ruleId = "creedengo-java:GCI5";
        String ruleMsg = "You must not use Statement for a DML query";
        int[] startLines = new int[]{18};
        int[] endLines = new int[]{18};

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines, SEVERITY, TYPE, EFFORT_10MIN);
    }

    @Test
    void testGCI79() {
        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/FreeResourcesOfAutoCloseableInterface.java";
        String ruleId = "creedengo-java:GCI79";
        String ruleMsg = "try-with-resources Statement needs to be implemented for any object that implements the AutoClosable interface.";
        int[] startLines = new int[]{23};
        int[] endLines = new int[]{36};

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines, SEVERITY, TYPE, EFFORT_15MIN);
    }

    @Test
    void testGCI32() {
        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/InitializeBufferWithAppropriateSize.java";
        String ruleId = "creedengo-java:GCI32";
        String ruleMsg = "Initialize StringBuilder or StringBuffer with appropriate size";
        int[] startLines = new int[]{16, 24};
        int[] endLines = new int[]{16, 24};

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);
    }

    @Test
    void testGCI67() {
        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/IncrementCheck.java";
        String ruleId = "creedengo-java:GCI67";
        String ruleMsg = "Use ++i instead of i++";
        int[] startLines = new int[]{9, 19, 38};
        int[] endLines = new int[]{9, 19, 38};

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);
    }

    @Test
    void testGCI82() {
        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/MakeNonReassignedVariablesConstants.java";
        String ruleId = "creedengo-java:GCI82";
        String ruleMsg = "The variable is never reassigned and can be 'final'";
        int[] startLines = new int[]{7, 12, 13, 45};
        int[] endLines = new int[]{7, 12, 13, 45};

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);
    }

    @Test
    void testGCI69() {
        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/NoFunctionCallWhenDeclaringForLoop.java";
        String ruleId = "creedengo-java:GCI69";
        String ruleMsg = "Do not call a function when declaring a for-type loop";
        int[] startLines = new int[]{58, 66, 74, 101};
        int[] endLines = new int[]{58, 66, 74, 101};

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);
    }

    @Test
    void testGCI94() {
        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/UseOptionalOrElseGetVsOrElse.java";
        String ruleId = "creedengo-java:GCI94";
        String ruleMsg = "Use optional orElseGet instead of orElse.";
        int[] startLines = new int[]{25};
        int[] endLines = new int[]{25};

        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines, SEVERITY, TYPE, EFFORT_1MIN);
    }

}
