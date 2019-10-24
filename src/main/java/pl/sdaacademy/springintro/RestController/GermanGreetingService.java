package pl.sdaacademy.springintro.RestController;

import org.springframework.stereotype.Service;

@Service("GermanGreetingService")
public class GermanGreetingService implements GreetingService{
    @Override
    public String greet() {
        return "Guten Tag Spring Boot";
    }
}
