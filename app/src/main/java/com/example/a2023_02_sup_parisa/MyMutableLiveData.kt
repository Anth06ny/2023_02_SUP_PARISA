package com.example.a2023_02_sup_parisa

import com.example.a2023_02_sup_parisa.model.WeatherBean

val liveData = MyMutableLiveData()

fun viewModel(){

    liveData.postValue("Toto")
    activity()

    liveData.postValue("")
}

fun activity(){

    liveData.observateur =  {
        println(it)
    }

}


class MyMutableLiveData {

    var data : String? = null

    var observateur : ((String?) -> Unit)? = null
    set(value) {
       field =value
       value?.invoke(data)
    }

    fun postValue(newData : String?){
        data = newData
        observateur?.invoke(data)
    }
}