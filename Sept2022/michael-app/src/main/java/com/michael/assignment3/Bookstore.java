package com.michael.assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class Bookstore {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Library library = new Library();
		
		System.out.println("Welcome to Michael's Bookstore!");
		System.out.print("Please enter your Customer ID: ");
		int customerID = s.nextInt();
		s.nextLine();
		
		
		
		System.out.print("Please enter your password: ");
		String password = s.nextLine();
		
		Order order = new Order();
		
		System.out.println("Here is our current library: ");
		library.show();
		
		while(true) {
			System.out.print("Would you like to search, add to cart, remove from cart, or checkout?");
			String response = s.nextLine();
			switch(response.toLowerCase().replaceAll("\\s", "")){
				case("addtocart"): 
					System.out.print("Enter the title of the item you'd like to add to your cart: ");
					order.addToOrder(s.nextLine(), library.library);
					break;
				case("removefromcart"):
					System.out.println("Here is your current cart: ");
					order.viewOrder();
					System.out.println("$" + order.total);
					System.out.println();
					System.out.print("Enter the title of the item you'd like to remove from your cart: ");
					order.removeFromOrder(s.nextLine());
					break;
				case("search"):
					System.out.print("Enter the title of the item you'd like to find: ");
					library.search(s.nextLine());
					break;
				case("checkout"):
					System.out.println("Here is your current cart: ");
					order.viewOrder();
					System.out.println("$" + order.total);
					System.out.println();
					System.out.println("Are you ready to submit your order?");
					if(s.nextLine().toLowerCase().replaceAll("\\s", "").equals("yes")) {
						System.out.println("Thank you for your order! You have been logged out.");
						System.exit(0);
					}
				default: 
					System.out.println("Invalid Response");
			}
		}
	}
}

class Order{
	
	ArrayList<Book> order;
	double total;
	
	public Order() {
		this.order = new ArrayList<Book>();
		this.total = 0.0;
	}
	
	public void viewOrder() {
		for(Book a : this.order) {
			System.out.println(a.getTitle() + " by " + a.getAuthor() + " $" + a.getPrice());
		}
	}
	
	public void addToOrder(String s, ArrayList<Book> library) {
		int size = this.order.size();
		for(Book a : library) {
			if(s.equalsIgnoreCase(a.getTitle())) {
				this.total += a.getPrice();
				this.order.add(a);
			}
		}
		if(size == this.order.size()) {
			System.out.println("Item could not be found in the library.");
		}	
	}
	

	public void removeFromOrder(String s) {
		int size = this.order.size();
		for(Book a : this.order) {
			if(a.getTitle().equalsIgnoreCase(s) || a.getAuthor().equalsIgnoreCase(s)) {
				this.total += a.getPrice();
				this.order.remove(a);
			}
		}
		if(size == this.order.size()) {
			System.out.println("Item could not be found in cart.");
		}	
	}
	
}

class Book{
	
	private int serialNo;
	private String title;
	private String author;
	private double price;
	
	public Book(int serialNo, String title, String author, double price) {
		this.serialNo = serialNo;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public int getSerialNo() {
		return this.serialNo;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public String toString() {
		return this.serialNo + ": " +  this.title + " by " + this.author + " $" + this.price;
	}
}

class Library{
	
	ArrayList<Book> library;
	
	public Library() {
		this.library =  new ArrayList<Book>();
		library.add(new Book(0001, "To Kill a Mockingbird", "Harper Lee", 10.28));
		library.add(new Book(0002, "The Great Gatsby", "F. Scott Fitzgerald", 3.84));
		library.add(new Book(0003, "Little Women", "Louisa May Alcott", 14.26));
		library.add(new Book(0004, "Pride and Prejudice", "Jane Austen", 17.99));
	}
	
	void show() {
		for(Book a : library) {
			System.out.println(a);
		}
	}
	
	public ArrayList<Book> search(String s) {
		ArrayList<Book> search = new ArrayList<Book>();
		for(Book i: library) {
			if(s.equalsIgnoreCase(i.getTitle()) || s.equalsIgnoreCase(i.getAuthor()) ) {
				search.add(i);
			}
		}
		return search;
	}
	
}

class Customer{
	int customerID;
	String firstName;
	String lastName;
	String billingAddress;
	String shippingAddress;
	String password;
	ArrayList<Order> orders;
	
	public Customer(int customerID, String firstName, String lastName, String billingAddress, String shippingAddress, String password) {
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
		this.password = password;
		this.orders = new ArrayList<Order>();
	}
	
	
}
