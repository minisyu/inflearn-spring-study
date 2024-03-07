package study.miniproject.company.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import study.miniproject.company.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByName(String name);
}
