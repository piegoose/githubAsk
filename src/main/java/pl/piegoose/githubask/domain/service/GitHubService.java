package pl.piegoose.githubask;

import org.springframework.stereotype.Service;
import pl.piegoose.githubask.dto.BranchResponse;
import pl.piegoose.githubask.dto.GitHubResponse;
import pl.piegoose.githubask.dto.RepoInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GitHubService {

    private final GitHubProxy proxy;

    public GitHubService(GitHubProxy proxy) {
        this.proxy = proxy;
    }

    public Map<String, RepoInfo> getUserRepoDetalis(String username) {
        List<GitHubResponse> resultsRepos = proxy.getRepoNameAndOwnerLogin(username);
        Map<String, RepoInfo> result = new HashMap<>();

        for (GitHubResponse repo : resultsRepos) {
            List<BranchResponse> branches = proxy.getBrachWithLastCommitAndSha(username, repo.name());
            if (!branches.isEmpty()) {
                BranchResponse mainBranch = branches.get(0);
                result.put(repo.name(),
                        new RepoInfo(
                                mainBranch.commit().sha(),
                                mainBranch.name(),
                                repo.owner().login()
                        )
                );
            }
        }
        return result;
    }
}


