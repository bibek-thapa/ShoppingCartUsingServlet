package com.example.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.domain.Item;

public class ResultService {
	
	
	ItemService itemService;
	Item item;
	
	public ResultService() 
	{
		
		itemService = new ItemService();
		
	}
	
	public Map<Integer,Item> calculate(String[] names) 
	{
		Map<Integer,Item> checkedItemList = new HashMap<>();
		
		for(int i = 0 ; i < names.length ; i ++) 
		{
			if(names[i]!=null && names[i]!="") {
			checkedItemList.put(itemService.getItem(Integer.parseInt(names[i])).getId(),itemService.getItem(Integer.parseInt(names[i])));
		
			}
			
			
		}
		
		return checkedItemList;	
	
	}

}
