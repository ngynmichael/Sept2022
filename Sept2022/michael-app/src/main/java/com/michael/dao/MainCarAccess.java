package com.michael.dao;

public class MainCarAccess {

    public static void main(String[] args) {

        CarDAO carRef=new CarDAOImpl();
        
        for(Car car:carRef.getAllCars()) {
            System.out.println("List of Cars "+car);
        }
        
        
    }

}