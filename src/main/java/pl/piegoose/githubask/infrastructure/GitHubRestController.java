package pl.piegoose.githubask.infrastructure;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piegoose.githubask.infrastructure.error.GlobalErrorHandler;
import pl.piegoose.githubask.infrastructure.error.InvalidHeaderException;
import pl.piegoose.githubask.infrastructure.github.dto.ResponseInfoGitHubDto;
import pl.piegoose.githubask.domain.service.GitHubService;
import pl.piegoose.githubask.infrastructure.github.GitHubProxy;
import pl.piegoose.githubask.infrastructure.github.dto.RepoInfo;

import java.util.Map;

@RestController
@Log4j2
@RequestMapping("/repo")
public class GitHubRestController {

    private final GitHubService service;

    public GitHubRestController(GitHubProxy client, GitHubService service) {

        this.service = service;
    }

    @GetMapping("{owner}")
    public ResponseEntity<ResponseInfoGitHubDto> getUserInfo(
            @PathVariable @Valid String owner, @RequestHeader(value = "Accept", required = true) String acceptHeader) {
        if (!"application/json".equalsIgnoreCase(acceptHeader)) {
            throw new InvalidHeaderException("Missing or invalid 'Accept: application/json' header");
        }
        Map<String, RepoInfo> body = service.getUserRepoDetalis(owner);
        ResponseInfoGitHubDto result = new ResponseInfoGitHubDto(body);
        return ResponseEntity.ok(result);
    }


}
