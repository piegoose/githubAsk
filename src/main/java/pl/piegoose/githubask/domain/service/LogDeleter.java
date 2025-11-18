package pl.piegoose.githubask.domain.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.piegoose.githubask.domain.repository.GitRepository;

@Service
@AllArgsConstructor
@Log4j2
public class LogDeleter {
    private final GitRepository repository;
    private final LogRetriver logRetriver;

    public void deleteById(Long id)
    {
        logRetriver.existById(id);
        repository.deleteById(id);
        log.info("Log with id: " + id + " has been deleted");

    }

}
