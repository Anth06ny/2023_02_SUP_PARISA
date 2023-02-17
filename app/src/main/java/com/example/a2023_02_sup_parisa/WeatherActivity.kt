package com.example.a2023_02_sup_parisa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.a2023_02_sup_parisa.databinding.ActivityWeatherBinding
import com.squareup.picasso.Picasso

class WeatherActivity : AppCompatActivity() {

    //IHM
    val binding by lazy { ActivityWeatherBinding.inflate(layoutInflater) }

    //Données
    val model by lazy { ViewModelProvider(this).get(WeatherViewModel::class.java) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //J'observe mes livedata qui contiennent mes données
        observeLiveData()

        //j'ecoute mon bouton
        binding.btLoad.setOnClickListener {
            model.loadData(binding.etCityName.text.toString())
        }
    }

    fun observeLiveData() {
        //J'observe une donnée. L'observateur se déclenche à l'inscription
        model.errorMessage.observe(this) {
            if (it.isNotBlank()) {
                binding.tvError.isVisible = true
                binding.tvError.text = it
            }
            else {
                binding.tvError.isVisible = false
            }
        }

        model.data.observe(this) {
            binding.tv.text = it?.name ?: "-"
            binding.tvWind.text = it?.wind?.speed?.toString() ?: "-"
            binding.tvTemp.text = it?.main?.temp?.toString() ?: "-"
            binding.tvMinMax.text = "( ${it?.main?.temp_min ?: "-"}° /  ${it?.main?.temp_max ?: "-"}° )"
            //Gestion de la collection
            if (!it?.weather.isNullOrEmpty()) {
                binding.tvDesc.text = it!!.weather!![0].description
                Picasso.get().load("https://openweathermap.org/img/wn/${it.weather!![0].icon}@4x.png")
                    .error(R.drawable.baseline_delete_forever_24)
                    .into(binding.ivTemp)
            }
            else {
                binding.tvDesc.text = "-"
                binding.ivTemp.setImageResource(R.drawable.baseline_delete_forever_24)
            }
        }

        model.runInProgress.observe(this) {
            binding.progressBar.isVisible = it
        }
    }
}