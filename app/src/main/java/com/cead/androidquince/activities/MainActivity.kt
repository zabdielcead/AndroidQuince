package com.cead.androidquince.activities

import android.app.Dialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.cead.androidquince.R
import com.cead.androidquince.presenter.MainPresenter
import com.cead.androidquince.smodel.City
import com.cead.androidquince.smodel.CityFind

class MainActivity : AppCompatActivity() , IMainActivity{
    // servicios REST y patron de diseño MVP

    var editPais : EditText ? = null
    var btnFind  : Button ? = null
    var txcountry : TextView ? = null

    var dialog : Dialog ? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setIdsViews()

        var mainPresenter = MainPresenter(this)

        mainPresenter.getCitysApi()

        btnFind!!.setOnClickListener{

            if(!editPais!!.text.isEmpty()){
                dialog!!.show() //dialog.dismiss()
                mainPresenter.getCityFindApi(editPais!!.text.toString())

            }
        }
    }


    fun setIdsViews(){
        editPais = findViewById(R.id.edCountry)
        btnFind  = findViewById(R.id.btnFindCountry)
        txcountry = findViewById(R.id.txtPais)

        // progress dialog
        dialog = ProgressDialog.progressDialog(this)

    }


    // vamos a traer primer servicio
    override fun citiesReady(city: City) {
        Toast.makeText(this@MainActivity, "BIEN $city", Toast.LENGTH_LONG).show()
        Log.i("cead", city.toString())
    }

    //consultar el pais por el usuario
    override fun getFindCountry(country: CityFind){
        txcountry!!.text = country.toString()
    }






}
