package com.example.a2023_02_sup_parisa

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a2023_02_sup_parisa.model.RequestUtils
import com.example.a2023_02_sup_parisa.model.WeatherBean
import kotlin.concurrent.thread

class WeatherViewModel : ViewModel() {

    var data: MutableLiveData<WeatherBean?> = MutableLiveData()
    var errorMessage = MutableLiveData("")
    var runInProgress = MutableLiveData(false)

    fun loadData(cityName: String) {
        //reset donnée
        //Post value déclenche l'observateur de la liveData
        data.postValue(null)
        errorMessage.postValue("")
        runInProgress.postValue(true)

        thread {
            try {
                data.postValue(RequestUtils.loadWeather(cityName))
            }
            catch (e: Exception) {
                e.printStackTrace()
                errorMessage.postValue("Une erreur est survenue : ${e.message}")
            }
            runInProgress.postValue(false)
        }
    }


}