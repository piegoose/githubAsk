package pl.piegoose.githubask.domain.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.piegoose.githubask.domain.model.LogEntity;
import pl.piegoose.githubask.domain.repository.GitRepository;

@Service
@AllArgsConstructor
@Log4j2
public class LogAdder {

    private final GitRepository repository;

    public LogEntity addLog(LogEntity logEntity){
        log.info("adding new log to repo: " + logEntity);
        return repository.save(logEntity);
    }
}
