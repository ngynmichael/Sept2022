package com.saran.model;

import lombok.Data;


public class Product {
	
	private String prdName="Laptop";
	private String prdPrice="123";
	
	public void  getProductDetails() {
		System.out.println("the produce name is "+prdName+"   "+"the product price is : "+prdPrice);
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public String getPrdPrice() {
		return prdPrice;
	}

	public void setPrdPrice(String prdPrice) {
		this.prdPrice = prdPrice;
	}
	
	
	

}
