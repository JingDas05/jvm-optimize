package top.treegrowth.tool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value = "hello")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value = "/{firstName}/{lastName}", method = RequestMethod.GET)
    public String hello(@PathVariable("firstName") String firstName,
                        @PathVariable("lastName") String lastName) {

        return String.format("{\"message\":\"Hello %s %s\"}", firstName, lastName);
    }

    @RequestMapping(value = "/{times}", method = RequestMethod.GET)
    public String circle(@PathVariable("times") Integer times) {
        for (int i = 0; i < 1000; i++) {
            try {
                wait(500);
            } catch (InterruptedException e) {
                return String.format("{\"for\":\"InterruptedException %d\"}", i);
            }
        }
        return String.format("{\"for\":\"circle %d\"}", times);
    }
}
