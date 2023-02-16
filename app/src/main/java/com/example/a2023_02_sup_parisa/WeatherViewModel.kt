package com.example.a2023_02_sup_parisa

import androidx.lifecycle.ViewModel
import com.example.a2023_02_sup_parisa.model.RequestUtils
import com.example.a2023_02_sup_parisa.model.WeatherBean

class WeatherViewModel : ViewModel() {

    var data: WeatherBean? = null
    var errorMessage = ""

    fun loadData(cityName: String) {
        //reset donnée
        data= null
        errorMessage = ""

        try {
            data = RequestUtils.loadWeather(cityName)
        }
        catch (e: Exception) {
            e.printStackTrace()
            errorMessage = "Une erreur est survenue : ${e.message}"
        }
    }
}