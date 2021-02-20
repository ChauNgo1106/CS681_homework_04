package edu.umb.cs681.hw04;

import java.time.LocalDateTime;

public class GroceryStore {
	protected String itemName;
	protected String type;
	protected float itemPrice;
	protected int itemQuantity;
	protected boolean checkQuality;
	protected LocalDateTime expiredDate;
	
	public GroceryStore() {
		
	}

	public GroceryStore(String itemName, String type, float itemPrice, int itemQuantity, boolean checkQuality,
			LocalDateTime creationTime) {
		super();
		this.itemName = itemName;
		this.type = type;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.checkQuality = checkQuality;
		this.expiredDate = creationTime;
	}

	
	public String getItemName() {
		return itemName;
	}
	
	public String getType() {
		return this.type;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public boolean isCheckQuality() {
		return checkQuality;
	}

	
	public LocalDateTime getCreationTime() {
		return expiredDate;
	}

	@Override
	public String toString() {
		
		String quality = this.checkQuality == true ? "yes" : "no";
		String expired = this.getCreationTime() == null ? "N/A" : this.expiredDate.toLocalDate().toString();
		String result = String.format("%-20s %-20s %-20s %-20s %-30s %-20s " ,itemName, type , itemPrice , itemQuantity,  quality, expired);
		//String result = itemName + "\t\t\t" + type + "\t\t " + itemPrice + "\t\t " + itemQuantity + "\t\t " + quality + "\t\t\t " + expired;
		return result;
	}
	
	
	
}
