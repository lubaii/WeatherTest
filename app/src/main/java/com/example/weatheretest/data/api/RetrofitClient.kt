package com.example.weatheretest.data.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val BASE_URL = "http://api.weatherapi.com/v1/"
    private const val API_KEY = "fa8b3df74d4042b9aa7135114252304"
    private const val MOSCOW_COORDINATES = "55.7569,37.6151"
    private const val FORECAST_DAYS = 3

    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val weatherApiService: WeatherApiService = retrofit.create(WeatherApiService::class.java)

    fun getApiKey(): String = API_KEY
    fun getMoscowCoordinates(): String = MOSCOW_COORDINATES
    fun getForecastDays(): Int = FORECAST_DAYS
}

