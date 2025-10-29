package pl.piegoose.githubask.infrastructure.github.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record RepoInfo(
        String lastCommitMessage,
        String sha,
        String owner
) {
}
