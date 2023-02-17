package com.example.a2023_02_sup_parisa

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a2023_02_sup_parisa.model.PokemonBean
import com.example.a2023_02_sup_parisa.model.RequestUtils
import kotlin.concurrent.thread

class PokemonViewModel : ViewModel() {

    var data: MutableLiveData<PokemonBean?> = MutableLiveData()
    var errorMessage = MutableLiveData("")
    var runInProgress = MutableLiveData(false)

    fun loadData() {
        //reset donnée
        //Post value déclenche l'observateur de la liveData
        data.postValue(null)
        errorMessage.postValue("")
        runInProgress.postValue(true)

        thread {
            try {
                data.postValue(RequestUtils.loadPokemon())
            }
            catch (e: Exception) {
                e.printStackTrace()
                errorMessage.postValue("Une erreur est survenue : ${e.message}")
            }
            runInProgress.postValue(false)
        }
    }
}