package tech.parkhurst.restapi.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tech.parkhurst.restapi.services.impl.MatchCollectionServiceImpl;

import java.io.IOException;

@EnableAsync
@Component
public class CollectionScheduler {
    private static final Logger logger = LoggerFactory.getLogger(CollectionScheduler.class);

    @Autowired
    private MatchCollectionServiceImpl matchCollectionServiceImpl;


    @Async
    @Scheduled(cron = "0 1 1 * * ?")
    public void dailyUpdate() throws IOException {
        logger.info("GIGGITY");
        matchCollectionServiceImpl.gatherMatchData();
        matchCollectionServiceImpl.gatherTeams();
    }
}
