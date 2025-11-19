package pl.piegoose.githubask.domain.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.piegoose.githubask.domain.model.LogEntity;
import pl.piegoose.githubask.infrastructure.error.LogNotFoundException;
import pl.piegoose.githubask.domain.repository.GitRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class LogRetriver {
    private final GitRepository repository;

    public Optional<LogEntity> findById(Long id) {
        return repository.findById(id);
    }

    public void existById(Long id) {
        findById(id)
                .orElseThrow(() -> new LogNotFoundException("Log with id :" + id + " not found.."));
    }

    public void updateById(Long id, LogEntity updatedLog) {
        existById(id);
        repository.updateById(id, updatedLog);
        log.info("Log with id: " + id + " has been updated");
    }
}
