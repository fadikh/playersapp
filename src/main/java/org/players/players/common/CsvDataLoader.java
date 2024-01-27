package org.players.players.common;

import com.opencsv.bean.CsvToBeanBuilder;
import org.players.players.entities.Player;
import org.players.players.repositories.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Configuration
public class CsvDataLoader {
    private static final Logger log = LoggerFactory.getLogger(CsvDataLoader.class);

    @Bean
    CommandLineRunner initDatabase(PlayerRepository repository) {
        return args -> {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream is = classLoader.getResourceAsStream("player.csv");

            List<Player> players = new CsvToBeanBuilder(new InputStreamReader(is))
                .withType(Player.class)
                .withSkipLines(1) // Used to skip 1st line. Because columns headers are in 1st line
                .build()
                .parse();

            repository.saveAll(players);
            log.info(players.size() + " Players persisted to DB");
        };
    }
}
