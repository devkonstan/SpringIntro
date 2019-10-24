package pl.sdaacademy.springintro.RestController;

import org.springframework.stereotype.Service;

@Service("EnglishGreetingService")
public class EnglishGreetingService implements GreetingService {
    @Override
    public String greet() {

        return "Hello Spring Boot!";
    }
}
