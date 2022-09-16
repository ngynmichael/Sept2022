package com.michael.michael_app;

class Person {
	int age;
	String sex;
	int ssn;
	
	public Person(int age, String sex, int ssn) {
		this.age = age;
		this.sex = sex;
		this.ssn = ssn;
	}
}

public class Student extends Person {
	double gpa;
	String classification;
	public Student(int age, String sex, int ssn, double gpa, String classification) {
		super(age, sex, ssn);
		this.gpa = gpa;
		this.classification = classification;
	}
	
	public static void main(String[] args) {
		Student sarah = new Student(15, "female", 111223333, 4.0, "Senior");
		System.out.println(sarah.age);
	}
	
}