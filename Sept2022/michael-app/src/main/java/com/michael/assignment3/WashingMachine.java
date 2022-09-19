package com.michael.assignment3;

public class WashingMachine {
	
	public boolean isOn;
	public int noClothes;
	public boolean hasDetergent;
	
	public WashingMachine() {
		this.isOn = false;
		this.noClothes = 0;
		this.hasDetergent = false;
	}
	
	public int acceptClothes(int clothes) {
		this.noClothes = clothes;
		return this.noClothes;
	}
	
	public void switchOn() {
		this.isOn = true;
	}
	
	public void switchOff() {
		this.isOn = false;
	}
	
	public void acceptDetergent() {
		this.hasDetergent = true;
	}
	
}
