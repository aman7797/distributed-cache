package com.cache.hazelcast.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cache.hazelcast.model.Item;
import com.cache.hazelcast.service.ItemService;

@RestController
public class Controller {

	@Autowired
    ItemService itemService;
    
    private static Logger log = LoggerFactory.getLogger(Controller.class);
    
    @GetMapping("/item/{itemId}")
    @ResponseBody
    public Object getItem(@PathVariable int itemId){
    	log.info("RestController..");
        long start = System.currentTimeMillis();
        Item item = itemService.getItemById(itemId);
        long end = System.currentTimeMillis();
        log.info("Took : " + ((end - start) / 1000+" sec.") + "   output   :: " + item);
		return item.toString();
        
    }
}
