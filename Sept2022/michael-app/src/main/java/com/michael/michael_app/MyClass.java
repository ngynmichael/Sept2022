package com.michael.michael_app;

class Multiplication{
	//Overload
	void multiply(int x, int y) {
		System.out.println(x * y);
	}
	void mulitply(double x, double y) {
		System.out.println(x * y);
	}
}

public class MyClass extends Multiplication{
	// Override
	void multiply(int x, int y, int z) {
		System.out.println(x *  y * z);
	}
}
