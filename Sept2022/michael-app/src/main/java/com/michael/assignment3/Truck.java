package com.michael.assignment3;

class Vehicle {

	int vehicleNo;
	String model;
	String manufacturer;
	String color;
	
	public Vehicle(int vehicleNo, String model, String manufacturer, String color) {
		this.vehicleNo = vehicleNo;
		this.model = model;
		this.manufacturer = manufacturer;
		this.color = color;
	}
}

public class Truck extends Vehicle{
	
	int loadingCapacity;
	
	public Truck(int vehicleNo, String model, String manufacturer, String color, int loadingCapacity) {
		super(vehicleNo, model, manufacturer, color);
		this.loadingCapacity = loadingCapacity;
	}
	
	void show() {
		System.out.println(this.vehicleNo + " " + this.model + " " + this.manufacturer + " " + this.color + " " + this.loadingCapacity);
	}
	
	public void changeLoadingCapacity(int newCapacity) {
		this.loadingCapacity = newCapacity;
		show();
	}
	
	public void changeColor(String newColor) {
		this.color = newColor;
		show();
	}
	
//	public static void main(String[] args) {
//		Truck truck = new Truck(1234, "Frontier", "Nissan", "Gray", 1000);
//		truck.show();
//		truck.changeColor("White");
//		truck.changeLoadingCapacity(2000);
//	}
}
