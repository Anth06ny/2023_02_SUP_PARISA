package com.example.a2023_02_sup_parisa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.a2023_02_sup_parisa.databinding.ActivityWeatherBinding
import com.example.a2023_02_sup_parisa.model.RequestUtils
import kotlin.concurrent.thread

class WeatherActivity : AppCompatActivity() {

    val binding by lazy { ActivityWeatherBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        val param = intent.getStringExtra("toto")
//        binding.textView.setText(param)

        binding.btLoad.setOnClickListener {

            binding.progressBar.isVisible = true

            //Début de la tache asynchrone
            thread {
                val data = RequestUtils.loadWeather("Toulouse")
                //Retour sur le thread graphique
                runOnUiThread {
                    binding.textView.setText("Il fait ${data.main.temp}° à ${data.name}")
                    binding.progressBar.isVisible = false
                }
            }
        }

    }
}