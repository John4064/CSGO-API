package tech.parkhurst.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableSwagger2
@EnableWebMvc
@EnableScheduling
@EnableJpaRepositories()
@SpringBootApplication
public class RestapiApplication {

    public static void main(String[] args) {
        //Collection Initial Matches
        SpringApplication.run(RestapiApplication.class, args);
        System.exit(2);
    }

}
