package com.hritik.WeatherCachePro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hritik.WeatherCachePro.services.WeatherService;

@RestController
@RequestMapping("api/weather")
public class WeatherController {

	@Autowired 
	WeatherService weatherService;
	
	@GetMapping("/{city}")
	public String getCityWeather(@PathVariable String city) {
		return weatherService.getCityWeather(city);
	}
}
