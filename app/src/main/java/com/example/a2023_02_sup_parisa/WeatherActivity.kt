package com.example.a2023_02_sup_parisa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.a2023_02_sup_parisa.databinding.ActivityWeatherBinding
import com.squareup.picasso.Picasso
import kotlin.concurrent.thread

class WeatherActivity : AppCompatActivity() {

    val binding by lazy { ActivityWeatherBinding.inflate(layoutInflater) }
    val model by lazy { ViewModelProvider(this).get(WeatherViewModel::class.java) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        val param = intent.getStringExtra("toto")
//        binding.textView.setText(param)

        refreshScreen()

        binding.btLoad.setOnClickListener {
            //Reset de donnée
            binding.tvError.isVisible = false
            binding.progressBar.isVisible = true
            val cityName = binding.etCityName.text.toString()

            //Début de la tache asynchrone
            thread {
                model.loadData(cityName)
                runOnUiThread {
                    refreshScreen()
                    binding.progressBar.isVisible = false
                }
            }
        }
    }

    fun refreshScreen() {
        binding.tv.text = model.data?.name ?: "-"
        binding.tvWind.text = model.data?.wind?.speed?.toString() ?: "-"
        binding.tvTemp.text = model.data?.main?.temp?.toString() ?: "-"
        binding.tvMinMax.text = "( ${model.data?.main?.temp_min ?: "-"}° /  ${model.data?.main?.temp_max ?: "-"}° )"
        //Gestion de la collection
        if (!model.data?.weather.isNullOrEmpty()) {
            binding.tvDesc.text = model.data!!.weather!![0].description
            Picasso.get().load("https://openweathermap.org/img/wn/${model.data!!.weather!![0].icon}@4x.png")
                .error(R.drawable.baseline_delete_forever_24)
                .into(binding.ivTemp)
        }

        //gestion de l'erreur
        if (model.errorMessage.isNotBlank()) {
            binding.tvError.isVisible = true
            binding.tvError.text = model.errorMessage
        }
        else {
            binding.tvError.isVisible = false
        }
    }
}