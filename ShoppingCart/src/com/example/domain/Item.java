package com.example.domain;

public class Item {

	int id;
	String name;
	float price;
	
	public Item() {}
	
	public Item(int id, String name , float price) 
	{
		this.id = id;
		this.name = name;
		this.price = price;
		
	}

	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	
	

}
