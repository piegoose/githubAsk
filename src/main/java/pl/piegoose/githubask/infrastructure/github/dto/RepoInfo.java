package pl.piegoose.githubask.github.dto;

public record RepoInfo(
        String lastCommitMessage,
        String sha,
        String owner
) {
}
