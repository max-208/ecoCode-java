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

    private static final String[] EXTRACT_FIELDS = new String[]{"rule", "message", "line", "textRange.startLine", "textRange.endLine",
            "textRange.startOffset", "textRange.endOffset", "severity", "type", "debt", "effort"};
    private static final Common.Severity SEVERITY = MINOR;
    private static final Common.RuleType TYPE = CODE_SMELL;
    private static final String DEBT = "5min";
    private static final String EFFORT = "5min";

    private void checkIssuesForFile(String filePath, String ruleId, String ruleMsg, int[] lines, int[] startOffsets, int[] endOffsets) {
        String[] ruleIds = new String[lines.length];
        String[] ruleMsgs = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            ruleIds[i] = ruleId;
            ruleMsgs[i] = ruleMsg;
        }
        checkIssuesForFile(filePath, ruleIds, ruleMsgs, lines, startOffsets, endOffsets, SEVERITY, TYPE, DEBT, EFFORT);
    }

    private void checkIssuesForFile(String filePath, String ruleId, String ruleMsg, int[] lines, int[] startOffsets, int[] endOffsets, Common.Severity severity, Common.RuleType type, String debt, String effort) {
        String[] ruleIds = new String[lines.length];
        String[] ruleMsgs = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            ruleIds[i] = ruleId;
            ruleMsgs[i] = ruleMsg;
        }
        checkIssuesForFile(filePath, ruleIds, ruleMsgs, lines, startOffsets, endOffsets, severity, type, debt, effort);
    }

    private void checkIssuesForFile(String filePath, String[] ruleIds, String[] ruleMsgs, int[] lines, int[] startOffsets, int[] endOffsets, Common.Severity severity, Common.RuleType type, String debt, String effort) {
        String projectKey = analyzedProjects.get(0).getProjectKey();
        List<Issues.Issue> issues = issuesForFile(projectKey, filePath);

        List<Tuple> expectedTuples = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            expectedTuples.add(Tuple.tuple(ruleIds[i], ruleMsgs[i], lines[i], lines[i], lines[i], startOffsets[i], endOffsets[i], severity, type, debt, effort));
        }

        assertThat(issues)
                .hasSize(lines.length)
                .extracting(EXTRACT_FIELDS)
                .containsExactlyElementsOf(expectedTuples);
    }

    @Test
    void testMeasuresAndIssues() {
        String projectKey = analyzedProjects.get(0).getProjectKey();

        Map<String, Measures.Measure> measures = getMeasures(projectKey);

        assertThat(ofNullable(measures.get("code_smells")).map(Measures.Measure::getValue).map(Integer::parseInt).orElse(0))
                .isGreaterThan(1);

        List<Issues.Issue> projectIssues = issuesForComponent(projectKey);
        assertThat(projectIssues).isNotEmpty();

    }

    @Test
    void testGCI3() {

        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidGettingSizeCollectionInForLoopBad.java";
        String[] ruleIds = {"creedengo-java:GCI3", "creedengo-java:GCI69"};
        String[] ruleMsgs = {"Avoid getting the size of the collection in the loop", "Do not call a function when declaring a for-type loop"};
        int[] lines = new int[]{13, 13};
        int[] startOffsets = new int[]{28, 28};
        int[] endOffsets = new int[]{45, 45};

        checkIssuesForFile(filePath, ruleIds, ruleMsgs, lines, startOffsets, endOffsets, MINOR, CODE_SMELL, "5min", "5min");

    }

    @Test
    void testGCI69() {
        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/NoFunctionCallWhenDeclaringForLoop.java";
        String ruleId = "creedengo-java:GCI69";
        String ruleMsg = "Do not call a function when declaring a for-type loop";
        int[] lines = new int[]{58, 66, 74, 101};
        int[] startOffsets = new int[]{28, 34, 39, 108};
        int[] endOffsets = new int[]{40, 46, 51, 132};

        checkIssuesForFile(filePath, ruleId, ruleMsg, lines, startOffsets, endOffsets);
    }

    @Test
    void testGCI82() {
        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/MakeNonReassignedVariablesConstants.java";
        String ruleId = "creedengo-java:GCI82";
        String ruleMsg = "The variable is never reassigned and can be 'final'";
        int[] lines = new int[]{7, 12, 13, 45};
        int[] startOffsets = new int[]{4, 4, 4, 8};
        int[] endOffsets = new int[]{67, 56, 50, 25};

        checkIssuesForFile(filePath, ruleId, ruleMsg, lines, startOffsets, endOffsets);
    }

    @Test
    void testGCI94() {
        String filePath = "src/main/java/org/greencodeinitiative/creedengo/java/checks/UseOptionalOrElseGetVsOrElse.java";
        String ruleId = "creedengo-java:GCI94";
        String ruleMsg = "Use optional orElseGet instead of orElse.";
        int[] lines = new int[]{25};
        int[] startOffsets = new int[]{38};
        int[] endOffsets = new int[]{69};

        checkIssuesForFile(filePath, ruleId, ruleMsg, lines, startOffsets, endOffsets, SEVERITY, TYPE, "1min", "1min");
    }

}
