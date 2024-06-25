package tech.buildrun.magalu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.buildrun.magalu.entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
