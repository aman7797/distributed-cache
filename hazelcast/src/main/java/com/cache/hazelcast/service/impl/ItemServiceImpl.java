package com.cache.hazelcast.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import com.cache.hazelcast.dao.ItemDao;
import com.cache.hazelcast.model.Item;
import com.cache.hazelcast.service.ItemService;

@Service
@CacheConfig(cacheNames = "item")
public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemDao itemDao;
	
	private static Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);
	
	@Override
	public void insertItem(Item emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertItems(List<Item> Items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Item> getAllItems() {
		return itemDao.getAllItems();
	}

	@Override
	public Item getItemById(int itemId) {
		Item item = itemDao.getItemById(itemId);
		log.info("Output for {} is :: {} " , itemId, item);	
		return item;
	}

}
