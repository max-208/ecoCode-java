package org.greencodeinitiative.creedengo.java.integration.tests;

import org.junit.jupiter.api.Test;
import org.sonarqube.ws.Issues;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.sonarqube.ws.Common.RuleType.CODE_SMELL;
import static org.sonarqube.ws.Common.Severity.MINOR;

class GCI94IT extends LaunchSonarqubeAndBuildProject {

    @Test
    void testGCI94() {
        String projectKey = analyzedProjects.get(0).getProjectKey();

        List<Issues.Issue> issuesForArrayCopyCheck = issuesForFile(projectKey, "src/main/java/org/greencodeinitiative/creedengo/java/checks/UseOptionalOrElseGetVsOrElse.java");

        assertThat(issuesForArrayCopyCheck)
                .hasSize(1)
                .first().satisfies(issue -> verifyIssue(issue, IssueDetails.builder()
                        .rule("creedengo-java:GCI94")
                        .message("Use optional orElseGet instead of orElse.")
                        .line(25)
                        .startLine(25)
                        .endLine(25)
                        .startOffset(38)
                        .endOffset(69)
                        .severity(MINOR)
                        .type(CODE_SMELL)
                        .debt("1min")
                        .effort("1min")
                        .build())
        );

    }

}
