package tech.parkhurst.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@EnableScheduling
@EnableJpaRepositories()
@SpringBootApplication
public class RestapiApplication {

    public static void main(String[] args) {
        //Collection Initial Matches
        SpringApplication.run(RestapiApplication.class, args);
    }

}
