package com.example.agroajuda.data.repository

import com.example.agroajuda.data.remote.AgroWeatherService
import com.example.agroajuda.data.remote.dto.WeatherResponseDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepository(private val weatherService: AgroWeatherService) {

    suspend fun getWeatherForecast(latitude: Double, longitude: Double): Result<WeatherResponseDto> {
        return withContext(Dispatchers.IO) {
            try {
                val response = weatherService.getForecast(latitude, longitude)
                Result.success(response)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}
