package pl.piegoose.githubask.infrastructure.github;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.piegoose.githubask.infrastructure.github.dto.BranchResponse;
import pl.piegoose.githubask.infrastructure.github.dto.GitHubResponse;

import java.util.List;
@FeignClient(name = "github", url = "${github.base-url}")
public interface GitHubProxy {


    @GetMapping("/users/{owner}/repos") // with forks
    List<GitHubResponse> getRepoNameAndOwnerLogin(
            @PathVariable("owner") String username);

    @GetMapping("/repos/{owner}/{repo}/branches")
    List<BranchResponse> getBrachWithLastCommitAndSha(
            @PathVariable("owner") String user,
            @PathVariable("repo") String repo);

}
