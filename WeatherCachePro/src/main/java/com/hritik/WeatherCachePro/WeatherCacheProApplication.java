package com.hritik.WeatherCachePro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class WeatherCacheProApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherCacheProApplication.class, args);
	}

}
