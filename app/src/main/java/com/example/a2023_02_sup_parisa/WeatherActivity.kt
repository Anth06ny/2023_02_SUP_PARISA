package com.example.a2023_02_sup_parisa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.a2023_02_sup_parisa.databinding.ActivityWeatherBinding
import com.example.a2023_02_sup_parisa.model.RequestUtils
import com.squareup.picasso.Picasso
import kotlin.concurrent.thread

class WeatherActivity : AppCompatActivity() {

    val binding by lazy { ActivityWeatherBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        val param = intent.getStringExtra("toto")
//        binding.textView.setText(param)

        binding.btLoad.setOnClickListener {

            //Reset de donnée
            binding.tvError.isVisible = false
            binding.progressBar.isVisible = true

            //Début de la tache asynchrone
            thread {
                try {
                    val data = RequestUtils.loadWeather("Toulouse")
                    //Retour sur le thread graphique
                    runOnUiThread {
                        binding.tv.text = data.name
                        binding.tvWind.text = data.wind.speed.toString()
                        binding.tvTemp.text = data.main.temp.toString()
                        binding.tvMinMax.text = "( ${data.main.temp_min}° /  ${data.main.temp_max}° )"
                        //Gestion de la collection
                        if (!data.weather.isNullOrEmpty()) {
                            binding.tvDesc.text = data.weather!![0].description
                            Picasso.get().load("https://openweathermap.org/img/wn/${data.weather!![0].icon}@4x.png")
                                .error(R.drawable.baseline_delete_forever_24)
                                .into(binding.ivTemp)
                        }

                        binding.progressBar.isVisible = false
                    }
                }
                catch (e: Exception) {
                    e.printStackTrace()
                    runOnUiThread {
                        binding.tvError.setText("Une erreur est survenue : ${e.message}")
                        binding.tvError.isVisible = true
                        binding.progressBar.isVisible = false
                    }
                }
            }
        }

    }
}