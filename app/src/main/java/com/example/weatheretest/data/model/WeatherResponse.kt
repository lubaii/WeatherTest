package com.example.weatheretest.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResponse(
    val location: Location,
    val current: Current,
    val forecast: Forecast
)

@JsonClass(generateAdapter = true)
data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val tz_id: String,
    val localtime_epoch: Long,
    val localtime: String
)

@JsonClass(generateAdapter = true)
data class Current(
    val last_updated_epoch: Long,
    val last_updated: String,
    val temp_c: Double,
    val temp_f: Double,
    val feelslike_c: Double,
    val feelslike_f: Double,
    val condition: Condition,
    val wind_mph: Double,
    val wind_kph: Double,
    val humidity: Int,
    val cloud: Int,
    val uv: Double
)

@JsonClass(generateAdapter = true)
data class Condition(
    val text: String,
    val icon: String,
    val code: Int
)

@JsonClass(generateAdapter = true)
data class Forecast(
    val forecastday: List<ForecastDay>
)

@JsonClass(generateAdapter = true)
data class ForecastDay(
    val date: String,
    val date_epoch: Long,
    val day: Day,
    val hour: List<Hour>
)

@JsonClass(generateAdapter = true)
data class Day(
    val maxtemp_c: Double,
    val maxtemp_f: Double,
    val mintemp_c: Double,
    val mintemp_f: Double,
    val avgtemp_c: Double,
    val avgtemp_f: Double,
    val condition: Condition,
    val maxwind_mph: Double,
    val maxwind_kph: Double,
    val totalprecip_mm: Double,
    val totalprecip_in: Double,
    val avgvis_km: Double,
    val avgvis_miles: Double,
    val avghumidity: Int,
    val uv: Double
)

@JsonClass(generateAdapter = true)
data class Hour(
    val time_epoch: Long,
    val time: String,
    val temp_c: Double,
    val temp_f: Double,
    val condition: Condition,
    val wind_mph: Double,
    val wind_kph: Double,
    val humidity: Int,
    val cloud: Int,
    val feelslike_c: Double,
    val feelslike_f: Double,
    val uv: Double
)

