package com.cache.hazelcast.service;

import java.util.List;

import com.cache.hazelcast.model.Item;

public interface ItemService {

	void insertItem(Item emp);
	void insertItems(List<Item> Items);
	List<Item> getAllItems();
	Item getItemById(int itemId);
}
