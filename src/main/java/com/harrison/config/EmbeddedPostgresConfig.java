package com.harrison.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;

@Component
@Profile("local")
public class EmbeddedPostgresConfig {

    @Bean
    public DataSource dataSource() throws IOException {
        return EmbeddedPostgres
                .builder()
                .setPort(15432)
                .start()
                .getPostgresDatabase();
    }

}
