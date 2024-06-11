package com.example.weatherapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.R
import com.example.weatherapp.api.WeatherApiService
import com.example.weatherapp.repository.WeatherRepository
import com.example.weatherapp.viewmodel.WeatherViewModel
import com.example.weatherapp.viewmodel.WeatherViewModelFactory

class WeatherFragment : Fragment() {
    private val weatherViewModel: WeatherViewModel by viewModels {
        WeatherViewModelFactory(WeatherRepository(WeatherApiService.create()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cityTextView: TextView = view.findViewById(R.id.cityTextView)
        val weatherTextView: TextView = view.findViewById(R.id.weatherTextView)


        val cityName = "Malmö"
        cityTextView.text = cityName

        weatherViewModel.weather.observe(viewLifecycleOwner) { weather ->
            val temperatureInKelvin = weather.main.temp
            val temperatureInCelsius = temperatureInKelvin - 273.15
            weatherTextView.text = getString(R.string.temperature_text, temperatureInCelsius)
        }


        val apiKey = "c291dacb96279cef99e9096a7006c92e"
        weatherViewModel.fetchWeather(cityName, apiKey)
    }
}
