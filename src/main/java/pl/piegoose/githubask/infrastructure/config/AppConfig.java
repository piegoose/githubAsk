package pl.piegoose.githubask.config;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RequestInterceptor githubAuthInterceptor(@Value("${github.token}") String token) {
        return tpl -> {
            tpl.header("Authorization", "Bearer " + token);
            tpl.header("Accept", "application/vnd.github+json");
            tpl.header("User-Agent", "github-ask-app");
        };
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }
}


