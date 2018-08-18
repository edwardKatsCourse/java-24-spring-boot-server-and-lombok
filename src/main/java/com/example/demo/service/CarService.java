package com.example.demo.service;

import com.example.demo.model.Car;

import java.util.List;

public interface CarService {

//    String addCar();
    void addCar(Car car);
    void updateCar(Car car);
    void deleteCar(Integer id);
    Car getById(Integer carId);
    List<Car> getAll();
}
