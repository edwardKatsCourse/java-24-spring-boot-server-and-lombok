package com.example.demo.repository;

import com.example.demo.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepository {
    static List<Car> cars = new ArrayList<>();

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public void updateCar(Car car) {
        cars
                .stream()
                .filter(x -> x.getId().equals(car.getId()))
                .findFirst()
                .ifPresent(oldCarData -> cars.set(oldCarData.getId() - 1, car));
    }

    @Override
    public void deleteCar(Integer carId) {
        cars.remove(carId - 1);
    }

    @Override
    public List<Car> getAll() {
        return cars;
    }

    @Override
    public Car getByCarId(Integer id) {
        return cars
                .stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
