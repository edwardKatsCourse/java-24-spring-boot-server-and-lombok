package com.example.demo.repository;

import com.example.demo.model.Car;

import java.util.List;

public interface CarRepository {

    void addCar(Car car);
    void updateCar(Car car);
    void deleteCar(Integer carId);
    List<Car> getAll();
    Car getByCarId(Integer id);
}
