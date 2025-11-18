package pl.piegoose.GitHubRepo;

import org.springframework.data.repository.CrudRepository;
import pl.piegoose.githubask.LogEntity;

import java.util.Optional;

public interface gitRepository extends CrudRepository<LogEntity, Long> {

    //todo CRUD na bazie danych (Dodawnie/Usuwanie/Odczytywanie/Update)


    Optional<LogEntity> findById(Long id);

    LogEntity save(LogEntity logEntity);

    LogEntity add(LogEntity logEntity);

    void deleteById(Long id);
}
