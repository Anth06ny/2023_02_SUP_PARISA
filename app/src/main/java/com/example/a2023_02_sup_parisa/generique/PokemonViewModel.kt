package com.example.a2023_02_sup_parisa.generique

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a2023_02_sup_parisa.generique.MyGeneriqueViewModel
import com.example.a2023_02_sup_parisa.model.PokemonBean
import com.example.a2023_02_sup_parisa.model.RequestUtils
import com.example.a2023_02_sup_parisa.model.WeatherBean
import kotlin.concurrent.thread

class PokemonViewModel : MyGeneriqueViewModel() {

    var data: MutableLiveData<PokemonBean?> = MutableLiveData()
//    var errorMessage = MutableLiveData("")
//    var runInProgress = MutableLiveData(false)


    override fun requestToDo() {
        data.postValue(RequestUtils.loadPokemon())
    }

//    fun loadData() {
//        //reset donnée
//        //Post value déclenche l'observateur de la liveData
//        data.postValue(null)
//        errorMessage.postValue("")
//        runInProgress.postValue(true)
//
//        thread {
//            try {
//                data.postValue(RequestUtils.loadPokemon())
//            }
//            catch (e: Exception) {
//                e.printStackTrace()
//                errorMessage.postValue("Une erreur est survenue : ${e.message}")
//            }
//            runInProgress.postValue(false)
//        }
//    }


}