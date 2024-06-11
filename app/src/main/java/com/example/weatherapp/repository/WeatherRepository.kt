package com.example.weatherapp.repository

import com.example.weatherapp.api.WeatherApiService
import com.example.weatherapp.model.WeatherResponse

class WeatherRepository(private val apiService: WeatherApiService) {

    suspend fun getWeather(city: String, apiKey: String): WeatherResponse {
        return apiService.getWeather(city, apiKey)
    }
}
