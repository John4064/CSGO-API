package tech.parkhurst.restapi.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableAsync
@Component
public class CollectionScheduler {
    private static final Logger logger = LoggerFactory.getLogger(CollectionScheduler.class);


    @Async
    @Scheduled(fixedRate = 60000L)
    public void test(){
        logger.info("Every minute!");
        return;
    }
}
