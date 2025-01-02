package org.greencodeinitiative.creedengo.java.integration.tests;

import org.junit.jupiter.api.Test;
import org.sonarqube.ws.Issues;
import org.sonarqube.ws.Measures;

import java.util.*;

import static java.util.Optional.ofNullable;
import static org.assertj.core.api.Assertions.assertThat;

class BaseIT extends LaunchSonarqubeAndBuildProject {

	@Test
	void testMeasuresAndIssues() {
		String projectKey = analyzedProjects.get(0).getProjectKey();

		Map<String, Measures.Measure> measures = getMeasures(projectKey);

		assertThat(ofNullable(measures.get("code_smells")).map(Measures.Measure::getValue).map(Integer::parseInt).orElse(0))
				.isGreaterThan(1);

		List<Issues.Issue> projectIssues = issuesForComponent(projectKey);
		assertThat(projectIssues).isNotEmpty();

	}

}
