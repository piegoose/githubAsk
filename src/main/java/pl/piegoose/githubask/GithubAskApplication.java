package pl.piegoose.githubask;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import pl.piegoose.githubask.infrastructure.github.GitHubProxy;

@SpringBootApplication
@EnableFeignClients(basePackages = "pl.piegoose.githubask")
@Log4j2
public class GithubAskApplication {

    private final GitHubProxy proxy;

    public GithubAskApplication(GitHubProxy proxy) {
        this.proxy = proxy;
    }

    public static void main(String[] args) {
        SpringApplication.run(GithubAskApplication.class, args);
    }

//    @EventListener(ApplicationStartedEvent.class)
//    public void run() {
//        List<GitHubResponse> repoNameAndOwnerLogin = proxy.getRepoNameAndOwnerLogin("kalqa");
//        log.info(repoNameAndOwnerLogin);
//        List<BranchResponse> brachWithLastCommitAndSha = proxy.getBrachWithLastCommitAndSha("kalqa", "LottoJJR");
//        log.info(brachWithLastCommitAndSha);
//    }


}


