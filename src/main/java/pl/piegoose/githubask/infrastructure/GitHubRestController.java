package pl.piegoose.githubask.infrastructure;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piegoose.githubask.domain.model.LogEntity;
import pl.piegoose.githubask.domain.service.GitHubService;
import pl.piegoose.githubask.domain.service.LogAdder;
import pl.piegoose.githubask.domain.service.LogDeleter;
import pl.piegoose.githubask.domain.service.LogRetriver;
import pl.piegoose.githubask.infrastructure.error.InvalidHeaderException;
import pl.piegoose.githubask.infrastructure.github.dto.RepoInfo;
import pl.piegoose.githubask.infrastructure.github.dto.ResponseInfoGitHubDto;

import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Log4j2
@RequestMapping("/repo")
public class GitHubRestController {

    private final GitHubService service;
    private final LogDeleter deleter;
    private final LogRetriver logRetriver;
    private final LogAdder logAdder;

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

    @DeleteMapping("/db/delete{id}")
    public ResponseEntity<String> deleteById(
            @RequestParam Long id) {
        deleter.deleteById(id);
        return ResponseEntity.ok("Log usuniety");
    }

    @GetMapping("/db/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id) {
        Optional<LogEntity> byId = logRetriver.findById(id);
        return ResponseEntity.ok("Log: " + byId);
    }

    @PostMapping("/db/add")
    public ResponseEntity<LogEntity> addLog(
            @RequestBody LogEntity newLog) {
        LogEntity savedLog = logAdder.addLog(newLog);
        return ResponseEntity.ok(savedLog);
    }
    @PostMapping("/db/update/{id}")
    public ResponseEntity<LogEntity> updateLog(
            @PathVariable Long id,
            @RequestBody LogEntity updatedLog){
        logRetriver.updateById(id,updatedLog);
        return ResponseEntity.ok((updatedLog));
    }


}