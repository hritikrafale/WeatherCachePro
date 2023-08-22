package com.hritik.WeatherCachePro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hritik.WeatherCachePro.services.CacheService;

@RestController
@RequestMapping("/api")
public class CacheController {

	@Autowired
	private CacheService cacheService;
	
	@GetMapping("/clear-cache")
	public String clearCache() {
		return cacheService.clearCache();
	}
}
