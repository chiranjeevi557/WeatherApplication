package com.example.weatherapplication.viewmodel

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.weatherapplication.model.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewmodel : ViewModel() {
    val api = "e5c45b78e47aa5a3a7631253456cadb0"
    val baseUrl = "https://api.openweathermap.org/data/2.5/"
    var cityTemp = ObservableField("Yet to be updated")
   // var objectData = ArrayList<WeatherResponse>()

    // var cityData: ObservableField<String> =ObservableField<String>("c")
    //var failure="check internet connection"
    var cityData = ObservableField<String>("c")
    fun movieDetails(view: View) {


        var retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()

        var serivce = retrofit.create(ApiInterface::class.java)
        val call = serivce.getWeather(cityData.get()!!, api)
        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                 val data=response.body()
                if(data!=null) {
                    cityTemp.set(data.base)
                    Log.d("data", "" + cityTemp)
                }

                //objectData.add(data!!)

            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Toast.makeText(view.context,"check internet connection",Toast.LENGTH_SHORT).show()
            }


        })

    }

}
