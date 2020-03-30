package com.cache.ehCache.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cache.ehCache.cache.ItemCache;
import com.cache.ehCache.model.Item;

@RestController
public class Controller{

    @Autowired
    ItemCache itemCache;
    
    private static Logger log = LoggerFactory.getLogger(Controller.class);
    
    @GetMapping("/item/{itemId}")
    @ResponseBody
    public ResponseEntity<Item> getItem(@PathVariable int itemId){
    	log.info("RestController..");
        long start = System.currentTimeMillis();
        Item item = itemCache.getItem(itemId);
        long end = System.currentTimeMillis();
        log.info("Took : " + ((end - start) / 1000+" sec.") + "   output   :: "  + item.getName());
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @PutMapping("/updateItem")
    @ResponseBody
    public ResponseEntity<Item> updateItem(@RequestBody Item item){
        if(item != null){
            itemCache.updateItem(item);
        }
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteItem(@PathVariable int id){
        itemCache.deleteItem(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping("/deleteall")
    @ResponseBody
    public ResponseEntity<Void> deleteAllItem(){
        itemCache.evictCache();
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

}