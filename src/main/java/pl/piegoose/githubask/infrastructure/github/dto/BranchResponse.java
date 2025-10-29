package pl.piegoose.githubask.infrastructure.github.dto;

import pl.piegoose.githubask.domain.model.Commit;

public record BranchResponse(String name, Commit commit) {
}
