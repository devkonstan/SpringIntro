package pl.sdaacademy.springintro;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Car {
    public int id;
    public String name;
    public String model;
    public int year;

    public Car() {
    }

    public Car(int id, String name, String model, int year) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.year = year;
    }

    public Car(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
