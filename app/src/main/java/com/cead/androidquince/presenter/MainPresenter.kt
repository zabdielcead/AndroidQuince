package com.cead.androidquince.presenter

import com.cead.androidquince.activities.IMainActivity
import com.cead.androidquince.service.API.IServiceCountry
import com.cead.androidquince.service.ApiCountryFindRetrofit
import com.cead.androidquince.service.ApiCountryRetrofit
import com.cead.androidquince.smodel.City
import com.cead.androidquince.smodel.CityFind
import retrofit2.Call
import retrofit2.Callback;
import retrofit2.Response

class MainPresenter {

    private  var mainActivity : IMainActivity


    constructor( view:  IMainActivity){
        this.mainActivity = view

    }

    fun getCitysApi(){
        var service:IServiceCountry  = ApiCountryRetrofit.getApi()!!.create(IServiceCountry::class.java)
        var cities : Call<City> = service.getCity("Seville,ES", ApiCountryRetrofit.APP_KEY)

        cities.enqueue(object : Callback<City>{
            override fun onFailure(call: Call<City>?, t: Throwable?) {
                try {
                    throw InterruptedException("error servicio CEAD")
                }catch(e:InterruptedException){
                    e.printStackTrace()
                }
            }

            override fun onResponse(call: Call<City>?, response: Response<City>?) {
               var superCity : City = response!!.body()

                if(superCity != null ){
                    mainActivity.citiesReady(superCity)
                }
            }

        })
    }

    fun getCityFindApi(countryFind: String){
        var serviceFind: IServiceCountry = ApiCountryFindRetrofit.getApi()!!.create(IServiceCountry::class.java)
        var citiesFind : Call<CityFind> = serviceFind.getCityCountry(countryFind, ApiCountryFindRetrofit.APP_KEY, "metric")

        citiesFind.enqueue(object : Callback<CityFind>{
            override fun onFailure(call: Call<CityFind>?, t: Throwable?) {
                try {
                    throw InterruptedException("error servicio CEAD")
                }catch(e:InterruptedException){
                    e.printStackTrace()
                }
            }

            override fun onResponse(call: Call<CityFind>?, response: Response<CityFind>?) {
                var cityFind : CityFind = response!!.body()

                if(cityFind != null ){
                    mainActivity.getFindCountry(cityFind)
                }
            }

        })


    }




}