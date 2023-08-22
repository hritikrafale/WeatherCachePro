package com.hritik.WeatherCachePro.services.impl;

import org.springframework.stereotype.Service;
import com.hritik.WeatherCachePro.services.CacheService;
import redis.clients.jedis.Jedis;

@Service
public class CacheServiceImpl implements CacheService {

	@Override
	public String clearCache() {

		Jedis jedis = new Jedis("localhost", 6379);
		jedis.connect();
		jedis.flushAll();
		jedis.disconnect();

		return "cache cleared!!!";
	}

}
