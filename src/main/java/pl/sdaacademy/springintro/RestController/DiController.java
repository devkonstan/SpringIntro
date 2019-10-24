package pl.sdaacademy.springintro.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiController {

    @Qualifier("FrenchGreetingService") //co mam wstrzyknac (jaki serwis) - określa typ, precyzuje lementacj
    @Autowired //adnotacja do wstrzykiwania
    GreetingService greetingService;

    @GetMapping("/greet")
    public String greet(){
        return greetingService.greet();
    }
}
