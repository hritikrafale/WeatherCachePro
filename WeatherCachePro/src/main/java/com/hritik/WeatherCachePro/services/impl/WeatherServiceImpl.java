package com.hritik.WeatherCachePro.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hritik.WeatherCachePro.model.WeatherData;
import com.hritik.WeatherCachePro.services.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Override
	public String getCityWeather(String city) {
		RestTemplate restTemplate = new RestTemplate();
		String apiUrl = "https://api.openweathermap.org/data/2.5/weather?appid=5684f10561a55344b39907734d0a2b28&units=metric&q="
				+ city;
		WeatherData weatherData = restTemplate.getForObject(apiUrl, WeatherData.class);

		return "This is weather report of " + weatherData.getMain().getTemp();
	}

}
