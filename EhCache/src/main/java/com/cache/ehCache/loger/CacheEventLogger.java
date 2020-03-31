package com.cache.ehCache.loger;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheEventLogger implements CacheEventListener<Object, Object>{
	
	private static Logger log = LoggerFactory.getLogger(CacheEventLogger.class);
	
	@Override
    public void onEvent(
      CacheEvent<? extends Object, ? extends Object> cacheEvent) {
		
		log.info("CacheEventKey 	   ==> {}", cacheEvent.getKey());
		log.info("CacheEvent Old Value ==> {}", cacheEvent.getOldValue());
		log.info("CacheEvent New Value ==> {}", cacheEvent.getNewValue());
       
    }

}
