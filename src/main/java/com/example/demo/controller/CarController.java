package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    //Dependency Injection
    @Autowired
    private CarService carService;

    //Inversion Of Control - IoC
    //Tomcat - IoC container
//    @GetMapping("/add") //<- ENTRY POINT!!!!
//    public String addCar() {
//        return carService.addCar();
//    }


    @GetMapping("/all")
    public List<Car> getAll() {
        return carService.getAll();
    }

    //cars/123
    @GetMapping("/{id}")
    public Car getById(@PathVariable("id") Integer id) {
        return carService.getById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Car car) {
        carService.addCar(car);
    }

    //cars/{path variable}
    @PutMapping("/{id}")
    public void updateCar(@RequestBody Car car,
                          @PathVariable(value = "id") Integer id) {
        car.setId(id);
        carService.updateCar(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable("id") Integer id) {
        carService.deleteCar(id);
    }

    //GET - получить инфу
    //POST - создать/выполнить
    //PUT - обновить существующую запись
    //DELETE - удалить
}
