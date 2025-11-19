package pl.piegoose.githubask.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.piegoose.githubask.domain.model.LogEntity;

import java.util.Optional;
@Repository
public interface GitRepository extends JpaRepository<LogEntity, Long> {

    //todo CRUD na bazie danych (Dodawnie/Usuwanie/Odczytywanie/Update)


    Optional<LogEntity> findById(Long id);

    LogEntity save(LogEntity logEntity);

    void deleteById(Long id);

    void updateById(Long id, LogEntity updatedLog);

}
