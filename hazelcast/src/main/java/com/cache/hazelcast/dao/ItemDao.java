package com.cache.hazelcast.dao;

import java.util.List;

import com.cache.hazelcast.model.Item;

public interface ItemDao {

	void insertItem(Item cus);
	void insertItems(List<Item> Items);
	List<Item> getAllItems();
	Item getItemById(int itemId);
}
