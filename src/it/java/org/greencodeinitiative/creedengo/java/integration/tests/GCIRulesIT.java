package org.greencodeinitiative.creedengo.java.integration.tests;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.sonarqube.ws.Common;
import org.sonarqube.ws.Issues;
import org.sonarqube.ws.Measures;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Optional.ofNullable;
import static org.assertj.core.api.Assertions.assertThat;
import static org.sonarqube.ws.Common.RuleType.CODE_SMELL;
import static org.sonarqube.ws.Common.Severity.MINOR;

class GCIRulesIT extends BuildProjectEngine {

    private static final String[] EXTRACT_FIELDS = new String[]{
            "rule", "message",
//            "line"
            "textRange.startLine", "textRange.endLine",
//            "textRange.startOffset", "textRange.endOffset",
            "severity", "type",
//            "debt",
            "effort"
    };
    private static final Common.Severity SEVERITY = MINOR;
    private static final Common.RuleType TYPE = CODE_SMELL;
    private static final String EFFORT_1MIN = "1min";
    private static final String EFFORT_5MIN = "5min";
    private static final String EFFORT_20MIN = "20min";

    private void checkIssuesForFile(String filePath, String ruleId, String ruleMsg, int[] startLines, int[] endLines) {
        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines, SEVERITY, TYPE, EFFORT_5MIN);
    }

    private void checkIssuesForFile(String filePath, String ruleId, String ruleMsg, int[] startLines, int[] endLines, Common.Severity severity, Common.RuleType type, String effort) {
        String projectKey = analyzedProjects.get(0).getProjectKey();
        List<Issues.Issue> issues = issuesForFile(projectKey, filePath, ruleId);

        List<Tuple> expectedTuples = new ArrayList<>();
        for (int i = 0; i < startLines.length; i++) {
            expectedTuples.add(Tuple.tuple(ruleId, ruleMsg, startLines[i], endLines[i], severity, type, effort));
        }

        assertThat(issues)
                .hasSizeGreaterThanOrEqualTo(startLines.length)
//                .hasSize(lines.length)
                .extracting(EXTRACT_FIELDS)
                .containsAll(expectedTuples);
//                .containsExactlyElementsOf(expectedTuples);
    }

    @Test
    void testMeasuresAndIssues() {
        String projectKey = analyzedProjects.get(0).getProjectKey();

        Map<String, Measures.Measure> measures = getMeasures(projectKey);

        assertThat(ofNullable(measures.get("code_smells")).map(Measures.Measure::getValue).map(Integer::parseInt).orElse(0))
                .isGreaterThan(1);

        List<Issues.Issue> projectIssues = issuesForComponent(projectKey, null);
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
    void testGCI3() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidGettingSizeCollectionInForLoopBad.java";
        int[] startLines = new int[]{13};
        int[] endLines = new int[]{13};
        String ruleId = "creedengo-java:GCI3";
        String ruleMsg = "Avoid getting the size of the collection in the loop";

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
    void testGCI82() {
        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/MakeNonReassignedVariablesConstants.java";
        String ruleId = "creedengo-java:GCI82";
        String ruleMsg = "The variable is never reassigned and can be 'final'";
        int[] startLines = new int[]{7, 12, 13, 45};
        int[] endLines = new int[]{7, 12, 13, 45};

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
