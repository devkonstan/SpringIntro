package pl.sdaacademy.springintro;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // Controller + ResponseBody
@RequestMapping("/user") //adnotacja odpowiedzialana za mapowanie zapytań webowych na metody Spring Controllera
public class UserController {
    private List<User> list;

    public UserController() {
        list = new ArrayList<>();
        list.add(new User("Piotr"));
        list.add(new User("Paweł"));
    }

    @PostMapping("/adduser")
    public List<User> addUser(@RequestBody User user) {
        list.add(user);
        return list;
    }

    @GetMapping("/getall")
    public List<User> getAllUsers() {
        return list;
    }
}
