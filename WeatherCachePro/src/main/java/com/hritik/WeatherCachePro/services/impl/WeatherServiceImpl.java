package com.hritik.WeatherCachePro.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hritik.WeatherCachePro.model.WeatherData;
import com.hritik.WeatherCachePro.services.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public String getCityWeather(String city) {

		String key = city;
		String value = "";

		if (redisTemplate.hasKey(city)) {
			value = redisTemplate.opsForValue().get(city);
		} else {

			// creating 10 secs delay
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}

			RestTemplate restTemplate = new RestTemplate();
			String apiUrl = "https://api.openweathermap.org/data/2.5/weather?appid=5684f10561a55344b39907734d0a2b28&units=metric&q="
					+ city;
			WeatherData weatherData = restTemplate.getForObject(apiUrl, WeatherData.class);
			value = "" + weatherData.getMain().getTemp();
			redisTemplate.opsForValue().set(key, value);
		}

		return "This is weather report of " + city + ":" + value;
	}
}
