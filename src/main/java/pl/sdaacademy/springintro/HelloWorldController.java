package pl.sdaacademy.springintro;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
// Endpoint - Może być wywoływany zdalnie. Metoda przyjmuje wartość stanowiącą relatywną ścieżkę dla jej wywołania;
    @RequestMapping(value = "/hello", method = RequestMethod.GET) //@GetMapping("/hello") tozsame
    public String helloWorld() {
        return "hello world!";
    }

    //http://localhost:8080/hello/request?name=Pawel
    @GetMapping("/request")
    public String requestParamExample(@RequestParam("name") String name) {
        return "hello -> " + name;
    }

    //http://localhost:8080/hello/square?number=4
    @GetMapping("/square")
    public Integer squareParam(@RequestParam("number") Integer number) {
        return number * number;
    }

    //http://localhost:8080/hello/sum?num1=3&num2=5
    @GetMapping("/sum")
    public Integer sumParam(@RequestParam("num1") int n1, @RequestParam("num2") int n2) {
        return n1 + n2;
    }

    //http://localhost:8080/hello/action?num1=3&num2=5&action=add
    @GetMapping("/action")
    public Float actionParam(@RequestParam("num1") float n1, @RequestParam("num2") float n2, @RequestParam("action") String action) {
        float result = 0;
        if (action.equals("minus")) {
            result = n1 - n2;
        } else if (action.equals("add")) {
            result = n1 + n2;
        } else if (action.equals("multiply")) {
            result = n1 * n2;
        } else if (action.equals("divide")) {
            result = n1 / n2;
        }

        return result;
    }

    //    http://localhost:8080/hello/car?id=4&name=polonez&model=x3&year=1994
    @GetMapping("/car")
    public Car carToJSON(@RequestParam("id") int id, @RequestParam("name") String name,
                         @RequestParam("model") String model, @RequestParam("year") int year) {
        return new Car(id, name, model, year);
    }

    private List<Car> list;

    //lista moze byc zadeklarowana na sztywno
    public HelloWorldController() {
        list = new ArrayList<>();
        list.add(new Car(1, "Fiat", "126p", 1994));
        list.add(new Car(2, "Fiat", "125", 1996));
    }

    @GetMapping("/car/{id}")
    public Car carList(@PathVariable("id") int id) {
        for (Car car : list) {
            if (car.id == (id)) {
                return car;
            }
        }
        return new Car(0);
    }


    @GetMapping("/getcars")
    public Iterable<Car> getAll() {
        return list;
    }

    @GetMapping("/getcars2")
    public List<Car> getCars() {
        return list;
    }

    @PostMapping("/addcar")
    public void addCar(@RequestBody Car car) {
        list.add(car);
    }

    @DeleteMapping
    public boolean removeCar(@RequestParam int id) {
        return list.removeIf(element -> element.getId()==id);
    }
}

