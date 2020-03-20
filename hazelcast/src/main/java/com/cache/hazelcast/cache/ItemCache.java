package com.cache.hazelcast.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.cache.hazelcast.model.Item;
import com.cache.hazelcast.repo.ItemRepository;

@Component
public class ItemCache {

    @Autowired
    ItemRepository itemRepo;
    
    private static Logger log = LoggerFactory.getLogger(ItemCache.class);

    @Cacheable(value="itemCache", key="#id")
    public Item getItem(int id){
        log.info("In ItemCache Component..");
        Item item = null;
        try{
            item = itemRepo.getItem(id);
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }
        return item;
    }

    @CacheEvict(value="itemCache",key = "#id")
    public int deleteItem(int id){
        log.info("In ItemCache Component..");
        return itemRepo.deleteItem(id);
    }

    @CachePut(value="itemCache")
    public void updateItem(Item item){
        log.info("In ItemCache Component..");
        itemRepo.updateItem(item);
    }
}