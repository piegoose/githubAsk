package pl.piegoose.githubask.github.dto;

import pl.piegoose.githubask.domain.model.Owner;

public record GitHubResponse(
        String name,
        Owner owner,
        boolean fork
) {
}
