package com.michael.assignment3;

public class Student {
	
	double studentAverage;
	String name;
	
	public Student() {
		this.studentAverage = 0.0;
		this.name = "";
	}
	
	public String average(double exam1, double exam2, double exam3) {
		this.studentAverage = (exam1 + exam2 + exam3) / 3;
		if(this.studentAverage > 50) {return "Pass";}
		return "Fail";
	}
	
	public String input(String n) {
		this.name = n;
		return this.name;
	}
	
}
