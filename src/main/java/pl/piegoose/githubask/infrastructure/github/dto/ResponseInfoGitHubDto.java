package pl.piegoose.githubask;

import pl.piegoose.githubask.infrastructure.github.dto.RepoInfo;

import java.util.Map;

public record ResponseInfoGitHub(Map<String, RepoInfo> repositoryInfo) {
}
