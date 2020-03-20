package com.cache.hazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;

@SpringBootApplication
@EnableAutoConfiguration
@EnableCaching
public class HazelcastApplication {

	@Bean
	 public Config hazelcastConfig(){
	       return new Config().setInstanceName("hazelcast-instance")
	                .addMapConfig(new MapConfig().setName("itemCache")
	                .setMaxSizeConfig(new MaxSizeConfig(300,MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
	                .setEvictionPolicy(EvictionPolicy.LRU) //LRU (Last Recent Use)
	                .setTimeToLiveSeconds(2000));
	    }
	
	public static void main(String[] args) {
		SpringApplication.run(HazelcastApplication.class, args);
	}

}
