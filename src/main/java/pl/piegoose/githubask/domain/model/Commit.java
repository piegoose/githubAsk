package pl.piegoose.githubask.dto;

public record Commit(
        String sha,
        CommitDetails commitDetails
) {
}
