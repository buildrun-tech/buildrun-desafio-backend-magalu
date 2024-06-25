package tech.buildrun.magalu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.buildrun.magalu.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
