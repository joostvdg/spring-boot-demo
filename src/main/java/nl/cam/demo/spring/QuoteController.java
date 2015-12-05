package nl.cam.demo.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by joost on 29-11-15.
 */
@RestController
public class QuoteController {

    private static final Logger log = LoggerFactory.getLogger(ApplicationStartupListener.class);

    @RequestMapping("/quote")
    public Quote quote() {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info(quote.toString());
        return quote;
    }
}
