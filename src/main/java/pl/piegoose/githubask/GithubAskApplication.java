package pl.piegoose.githubask.githubproxy.feignclient.dto.infrastructure;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;
import pl.piegoose.githubask.githubproxy.GitHubProxy;
import pl.piegoose.githubask.githubproxy.ResponseOwnerLoginDto;
import pl.piegoose.githubask.githubproxy.feignclient.dto.ResponseBranchDto;

import java.util.List;

@EnableFeignClients(basePackages = "pl.piegoose.githubask.githubproxy")
@SpringBootApplication
@Log4j2
public class GithubAskApplication {

    private final GitHubProxy proxy;

    public GithubAskApplication(GitHubProxy proxy) {
        this.proxy = proxy;
    }

    public static void main(String[] args) {
        SpringApplication.run(GithubAskApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() {
        List<ResponseOwnerLoginDto> repoNameAndOwnerLogin = proxy.getRepoNameAndOwnerLogin("kalqa");
        log.info(repoNameAndOwnerLogin);
        ResponseBranchDto brachWithLastCommitAndSha = proxy.getBrachWithLastCommitAndSha("kalqa", "LottoJJR");
        log.info(brachWithLastCommitAndSha);
    }


}


