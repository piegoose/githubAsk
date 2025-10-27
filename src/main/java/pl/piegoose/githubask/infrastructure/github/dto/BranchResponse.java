package pl.piegoose.githubask.github.dto;

import pl.piegoose.githubask.domain.model.Commit;

public record BranchResponse(String name, Commit commit
) {
}
