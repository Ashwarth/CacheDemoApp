package com.cache.CacheDemoApp.cfg;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;

import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;

@org.springframework.context.annotation.Configuration
@EnableCaching
public class CacheConfig extends  CachingConfigurerSupport{

	public net.sf.ehcache.CacheManager ehCacheManager(){
		
		CacheConfiguration studentCache10s = new CacheConfiguration();
		studentCache10s.setName("studentCache");
		studentCache10s.setMemoryStoreEvictionPolicy("LRU");
		studentCache10s.setMaxEntriesLocalHeap(1000);
		studentCache10s.setTimeToLiveSeconds(1000);
		
		
		
		Configuration cacheCfg = new Configuration();
		cacheCfg.addCache(studentCache10s);
		return net.sf.ehcache.CacheManager.newInstance(cacheCfg);
	}
	
	
	@Bean
	@Override
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManager());
	}
}
