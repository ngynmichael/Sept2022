package com.michael.michael_app;

import java.util.*;

public class Operations {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your first number: ");
		int x = sc.nextInt();
		System.out.print("Enter your second number: ");
		int y = sc.nextInt();
		
		System.out.println("Addition: " + (x + y));
		System.out.println("Subtraction: " + (x - y));
		System.out.println("Multiplication: " + (x * y));
		System.out.println("Division: " + (x / y));
		System.out.println("Modulus" + (x % y));
		System.out.println("Equal to: " + (x == y));
		System.out.println("Not Equal to: " + (x != y));
		System.out.println("Greater than: " + (x > y));
		System.out.println("Less than: " + (x < y));
		System.out.println("Greater than or equal to: " + (x >= y));
		System.out.println("Less than or equal to: " + (x <= y));
		
		System.out.println("Enter a number: ");
		int z = sc.nextInt();
		if(z % 2 == 0) {
			System.out.println(z + " is even");
		}
		else {
			System.out.println(z + " is odd");
		}
		
		System.out.println("Enter a number 1 to 10: ");
		int a = sc.nextInt();
		while(a < 0 && a > 10) {
			System.out.println("Invalid input! Enter a number 1 to 10: ");
			a = sc.nextInt();
		}
		switch(a) {
			case(1): System.out.println("One");
			case(2): System.out.println("Two");
			case(3): System.out.println("Three");
			case(4): System.out.println("Four");
			case(5): System.out.println("Five");
			case(6): System.out.println("Six");
			case(7): System.out.println("Seven");
			case(8): System.out.println("Eight");
			case(9): System.out.println("Nine");
			case(10): System.out.println("Ten");
		}
		
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.println(j);
			}
		}
		
		int b = 1;
		while(b <= 25) {
			System.out.println(b);
			b++;
		}
		
		int c = 50;
		do {
			if(c % 2 == 1) {
				System.out.println(c);
				c++;
			}
		}
		while(c <= 100);
		
		for(int i = 1; i <= 100; i++) {
			if(isPrime(i)) {
				System.out.println(i);
			}
		}
		
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 1) {
				System.out.println(i);
			}
			else {
				continue;
			}
		}
		
		for(int i = 50; i <= 100; i++) {
			if(i % 2 == 0 && i <= 75) {
				System.out.println(i);
			}
			else {
				break;
			}
		}
		
	}
	
	static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
  
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
  
        return true;
    }
	
	
}
