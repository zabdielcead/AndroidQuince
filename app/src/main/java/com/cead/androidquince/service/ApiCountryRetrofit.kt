package com.cead.androidquince.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCountryRetrofit {

    companion object {
        val BASE_URL = "http://api.openweathermap.org/data/2.5/"
        var  retrofit : Retrofit?  = null
        val APP_KEY = "9fcf0b3af833ecf680416626b1854950"

        fun getApi(): Retrofit? {
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }


            return retrofit
        }


    }
}