package com.example.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.domain.Item;

public class ItemService {
	
	Map<Integer,Item> itemList ;
	
	public ItemService() 
	{
		itemList = new HashMap<>();
		itemList.put(1, new Item(1,"Mouse",44.55f));
		itemList.put(2, new Item(2,"Brush",4.55f));
		itemList.put(3, new Item(3,"Onion",1.55f));
		itemList.put(4, new Item(4,"Laptop",4455f));
		
	}
	
	public Collection<Item> getAllItems()
	{
		return itemList.values();
	}
	
	public Item getItem(int location) 
	{
	
		return itemList.get(location);
	}
	


}
