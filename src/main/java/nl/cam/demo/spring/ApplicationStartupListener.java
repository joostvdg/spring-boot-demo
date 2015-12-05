package nl.cam.demo.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by joost on 29-11-15.
 */
@Component
public class ApplicationStartupListener implements ApplicationListener<ApplicationStartedEvent>{

    private static final Logger log = LoggerFactory.getLogger(ApplicationStartupListener.class);

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info(quote.toString());
    }
}
