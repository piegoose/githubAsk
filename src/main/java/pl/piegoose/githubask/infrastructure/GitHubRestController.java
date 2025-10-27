package pl.piegoose.githubask;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.piegoose.githubask.domain.service.GitHubService;
import pl.piegoose.githubask.github.GitHubProxy;
import pl.piegoose.githubask.github.dto.RepoInfo;

import java.util.Map;

@RestController
@Log4j2
public class GitHubRestController {

    private final GitHubProxy client;
    private final GitHubService service;

    public GitHubRestController(GitHubProxy client, GitHubService service) {
        this.client = client;
        this.service = service;
    }

//    @GetMapping("/repo/{owner}/{repo}")
//    public ResponseEntity<List<BranchResponse>> findAllRepos(@PathVariable("owner") String owner,
//                                                             @PathVariable("repo") String repo) {
//        return ResponseEntity.ok(null);
//    }
//
//    @GetMapping("/repo/{userName}")
//    public ResponseEntity<List<GitHubResponse>> firstCondition(
//            @PathVariable("userName") String user,
//            @PathVariable("owner")String owner,
//            @PathVariable("repo")String repo) {
//        List<GitHubResponse> body = service.getAllInfos(user,owner,repo);
//
//        return ResponseEntity.ok(body);
//    }
//    @GetMapping("/repo/{owner}/{repoName}")
//    public ResponseEntity<List<BranchResponse>> secondConditoin(
//            @PathVariable String owner,
//            @PathVariable String repoName
//    )
//    {
//        List<BranchResponse> brachWithLastCommitAndSha = client.getBrachWithLastCommitAndSha(owner, repoName);
//
//        return ResponseEntity.ok(brachWithLastCommitAndSha);
//    }

    @GetMapping("/repo/{owner}")
    public ResponseEntity<Map<String, RepoInfo>> getUserInfo(@PathVariable String owner){

        Map<String, RepoInfo> body = service.getUserRepoDetalis(owner);
        log.info(body);

        return ResponseEntity.ok(body);
    }


}
