package demo.quarkus;

import demo.quarkus.entities.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RestController
public class SpringGreetingController {

    @GetMapping("/hello-spring")
    public String hello() {
        return "Hello Spring";
    }

    @PostMapping("/person")
    @Transactional
    public void addPerson(@RequestBody Person person) {
        log.info("Request: {}", person);
        Person.persist(person);
    }

    @GetMapping("/person")
    @Transactional
    public List<Person> getPerson() {
        return Person.listAll();
    }
}
