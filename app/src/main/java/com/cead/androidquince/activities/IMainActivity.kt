package com.cead.androidquince.activities

import com.cead.androidquince.smodel.City
import com.cead.androidquince.smodel.CityFind

interface IMainActivity {

    fun citiesReady(city: City)

    fun getFindCountry(country: CityFind)

}