package pl.piegoose.githubask.domain.model;

import pl.piegoose.githubask.infrastructure.github.dto.CommitDetails;

public record Commit(
        String sha,
        CommitDetails commitDetails
) {
}
