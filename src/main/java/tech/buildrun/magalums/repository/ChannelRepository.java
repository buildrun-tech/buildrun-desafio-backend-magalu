package tech.buildrun.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.buildrun.magalums.entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
