package com.michael.dao;
import java.util.ArrayList;
import java.util.List;

public class CarDAOImpl implements CarDAO{
    
      //assume it list is working as a database
      private List<Car> car;
      
      public CarDAOImpl() {
          car=new ArrayList<>();
          car.add(new Car(1,"BMW"));
          car.add(new Car(2,"Bentley"));
          car.add(new Car(3,"Mazaratti"));
           
      }
      
    @Override
    public List<Car> getAllCars() {
        // TODO Auto-generated method stub
        return car;
    }

    @Override
    public Car getCarById(int carId) {
        return car.get(carId);
    }

    @Override
    public void saveCar(Car cars) {
        car.add(cars);
        
    }

    @Override
    public void deleteCar(Car cars) {
       car.remove(cars);
        
    }

}