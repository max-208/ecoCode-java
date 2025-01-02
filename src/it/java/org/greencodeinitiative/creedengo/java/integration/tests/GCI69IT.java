package org.greencodeinitiative.creedengo.java.integration.tests;

import org.junit.jupiter.api.Test;
import org.sonarqube.ws.Issues;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.sonarqube.ws.Common.RuleType.CODE_SMELL;
import static org.sonarqube.ws.Common.Severity.MINOR;

class GCI69IT extends LaunchSonarqubeAndBuildProject {

    @Test
    void testGCI69() {
        String projectKey = analyzedProjects.get(0).getProjectKey();

        List<Issues.Issue> issuesForArrayCopyCheck = issuesForFile(projectKey, "src/main/java/org/greencodeinitiative/creedengo/java/checks/AvoidGettingSizeCollectionInForLoopIgnored.java");

        assertThat(issuesForArrayCopyCheck)
                .hasSize(1)
                .first().satisfies(issue -> verifyIssue(issue, IssueDetails.builder()
                        .rule("creedengo-java:GCI69")
                        .message("Do not call a function when declaring a for-type loop")
                        .line(18)
                        .startLine(18)
                        .endLine(18)
                        .startOffset(15)
                        .endOffset(27)
                        .severity(MINOR)
                        .type(CODE_SMELL)
                        .debt("5min")
                        .effort("5min")
                        .build())
                );

    }

}
