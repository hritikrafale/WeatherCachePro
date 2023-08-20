package com.hritik.WeatherCachePro.services;

import org.springframework.stereotype.Service;

@Service
public interface WeatherService {

	public String getCityWeather(String city);
	
}
