package com.cache.ehCache.loger;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

public class CacheEventLogger implements CacheEventListener<Object, Object>{
	
	@Override
    public void onEvent(
      CacheEvent<? extends Object, ? extends Object> cacheEvent) {
		System.out.println("cacheEventKey -->" + cacheEvent.getKey() + "cacheEvent Old Value -->" + cacheEvent.getOldValue() 
			+ "cacheEvent NewValue" + cacheEvent.getNewValue());
       
    }

}
