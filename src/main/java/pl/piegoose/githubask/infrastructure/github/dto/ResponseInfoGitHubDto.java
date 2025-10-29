package pl.piegoose.githubask.infrastructure.github.dto;

import java.util.Map;

public record ResponseInfoGitHubDto(Map<String, RepoInfo> repositoryInfo) {
}
