package com.cache.hazelcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cache.hazelcast.cache.ItemCache;
import com.cache.hazelcast.model.Item;

@RestController
public class Controller{

    @Autowired
    ItemCache itemCache;
    @GetMapping("/item/{itemId}")
    @ResponseBody
    public ResponseEntity<Item> getItem(@PathVariable int itemId){
        System.out.println("RestController..");
        long start = System.currentTimeMillis();
        Item item = itemCache.getItem(itemId);
        long end = System.currentTimeMillis();
        System.out.println("Took : " + ((end - start) / 1000+" sec."));
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

}