package tech.buildrun.magalu.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import tech.buildrun.magalu.entity.Channel;
import tech.buildrun.magalu.entity.Status;
import tech.buildrun.magalu.repository.ChannelRepository;
import tech.buildrun.magalu.repository.StatusRepository;

import java.util.stream.Stream;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final ChannelRepository channelRepository;
    private final StatusRepository statusRepository;

    public DataLoader(ChannelRepository channelRepository,
                      StatusRepository statusRepository) {
        this.channelRepository = channelRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Stream.of(Channel.Values.values())
                .map(Channel.Values::toEntity)
                .forEach(channelRepository::save);


        Stream.of(Status.Values.values())
                .map(Status.Values::toEntity)
                .forEach(statusRepository::save);
    }
}
