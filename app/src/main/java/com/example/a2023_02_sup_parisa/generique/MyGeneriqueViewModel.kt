package com.example.a2023_02_sup_parisa.generique

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a2023_02_sup_parisa.model.RequestUtils
import kotlin.concurrent.thread

abstract class MyGeneriqueViewModel : ViewModel() {

    var errorMessage = MutableLiveData("")
    var runInProgress = MutableLiveData(false)

    abstract fun  requestToDo()

    fun loadData(){
        //reset donnée
        //Post value déclenche l'observateur de la liveData
        errorMessage.postValue("")
        runInProgress.postValue(true)

        thread {
            try {
                requestToDo()
            }
            catch (e: Exception) {
                e.printStackTrace()
                errorMessage.postValue("Une erreur est survenue : ${e.message}")
            }
            runInProgress.postValue(false)
        }
    }



}