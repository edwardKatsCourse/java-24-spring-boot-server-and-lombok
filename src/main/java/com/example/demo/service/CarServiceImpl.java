package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


//bean name - implementation (new CarServiceImpl)
@Service
public class CarServiceImpl implements CarService {

    //SpEL - Spring Expression Language
    @Value(value = "${java.24.property}")
    private String java24Value;

    @Autowired
    private CarRepository carRepository;

//    @Override
//    public String addCar() {
//
//        return java24Value;
//    }


    @Override
    public void addCar(Car car) {
        //size = 0 -> carId = .size() + 1
        car.setId(getAll().size() + 1);
        carRepository.addCar(car);
    }

    @Override
    public Car getById(Integer carId) {
        return carRepository.getByCarId(carId);
    }

    @Override
    public List<Car> getAll() {
        return carRepository.getAll();
    }

    @Override
    public void updateCar(Car car) {
        if (car.getId() == null) {
            addCar(car);
            return;
        }

        carRepository.updateCar(car);
    }

    @Override
//    @SneakyThrows
    public void deleteCar(Integer id) {
//        FileInputStream fileInputStream = new FileInputStream("asd");
//        fileInputStream.read();
//        Thread.sleep(1000);
        carRepository.deleteCar(id);
    }

    private void lombokExample() {
        Car car = new Car();
        List<String> previousOwners = car.getPreviousOwners();
        if (previousOwners == null) {
            previousOwners = new ArrayList<>();
        }
        previousOwners.add("asd");
        previousOwners.add("asd");
        previousOwners.add("asd");
        car.setBrand("");
        car.setKmRun(1);

        Car opel = Car.builder()
                .brand("Opel")
                .kmRun(60000)
                .model("Astra")
                .year(2014)
                .previousOwner("Natalie")
                .previousOwner("Peter")
                .previousOwner("Michael")
                .previousOwner("Igor")
                .build();


    }
}
