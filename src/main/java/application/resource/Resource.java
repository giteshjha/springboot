package application.resource;

import io.micrometer.core.annotation.Counted;
//import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.prometheus.client.Counter;

import java.util.Random;

@RestController
public class Resource {

//    private final Counter successes = Metrics.counter("eds.requests", "result", "success");
//    private final Counter failures = Metrics.counter("eds.requests", "result", "failure");
    static final Counter requests = Counter.build().name("requests_total").help("Total requests.").register();
//    @GetMapping("/hello-world")
//    String helloWorld(){
//        Random random = new Random();
//        successes.increment();
//        int x = random.nextInt(50);
//        if(x%2 == 0){
//            failures.increment();
//            throw new RuntimeException();
//        }
//        return "Hello World!";
//    }

    @GetMapping("/hello")
    @Counted(value = "hello.api.counter")
    String hello(){
        requests.inc();
        Random random = new Random();
//        successes.increment();
        int x = random.nextInt(50);
//        if(x%2 == 0){
//            failures.increment();
//            throw new RuntimeException();
//        }
        return "Hello!";
    }
}

