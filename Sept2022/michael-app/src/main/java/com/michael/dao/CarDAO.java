package com.michael.dao;

import java.util.List;
//loosely coupled
public interface CarDAO {
  
  List<Car> getAllCars();
  Car getCarById(int carId);
  void saveCar(Car car);
  void deleteCar(Car car);
  

}
//Advance concepts of DAO  public interface CarRepository extends JpaRepository{}
//findAll findById  Program to Inteface not to an implementation