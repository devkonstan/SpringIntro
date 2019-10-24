package pl.sdaacademy.springintro.RestController;

import org.springframework.stereotype.Service;

@Service("FrenchGreetingService")
public class FrenchGreetingService implements GreetingService {
    @Override
    public String greet() {

        return "Bonjour Spring Boot";
    }
}
