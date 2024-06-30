package tech.buildrun.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.buildrun.magalums.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
