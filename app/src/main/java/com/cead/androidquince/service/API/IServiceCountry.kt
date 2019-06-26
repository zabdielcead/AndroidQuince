package com.cead.androidquince.service.API


import com.cead.androidquince.smodel.City
import com.cead.androidquince.smodel.CityFind
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IServiceCountry {
    //http://api.openweathermap.org/data/2.5/weather?q=Seville,es&appid=9fcf0b3af833ecf680416626b1854950

    // 9fcf0b3af833ecf680416626b1854950
    // weather?q=Seville,es&appid=9fcf0b3af833ecf680416626b1854950
    @GET("weather")
    fun getCity(@Query("q") city: String, @Query("appid") key: String ): Call<City>

    @GET("weather")
    fun getCityCountry(@Query("q") city: String, @Query("appid") key: String , @Query("units") value: String): Call<CityFind>

}