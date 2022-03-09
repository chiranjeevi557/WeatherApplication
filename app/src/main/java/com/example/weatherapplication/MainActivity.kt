package com.example.weatherapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapplication.databinding.ActivityMainBinding
import com.example.weatherapplication.viewmodel.MainViewmodel

class MainActivity : AppCompatActivity() {
    lateinit var dataBinding:ActivityMainBinding
   // lateinit var datamodel: MainViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var datamodel: MainViewmodel
       // setContentView(R.layout.activity_main)
        dataBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        datamodel=ViewModelProvider(this).get(MainViewmodel::class.java)

       dataBinding.viewdata=datamodel
       /* datamodel.cityData=dataBinding.editText.text.toString()
        dataBinding.button.setOnClickListener()
        {
            datamodel.cityData=dataBinding.editText.text.toString()
            datamodel.movieDetails()
            dataBinding.Temperature.text= datamodel.objectData.get(0).main.temp.toString()
           // var index=0
           Log.d("data",""+datamodel.objectData.get(0).base)


        }*/
        //dataBinding.Temperature.text= datamodel.objectData.get(0).main.temp.toString()


    }
}