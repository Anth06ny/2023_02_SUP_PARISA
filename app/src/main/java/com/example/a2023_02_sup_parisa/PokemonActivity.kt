package com.example.a2023_02_sup_parisa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.a2023_02_sup_parisa.databinding.ActivityPokemonBinding
import com.example.a2023_02_sup_parisa.databinding.ActivityWeatherBinding
import com.squareup.picasso.Picasso

class PokemonActivity : AppCompatActivity() {

    //IHM
    val binding by lazy { ActivityPokemonBinding.inflate(layoutInflater) }

    //Données
    val model by lazy { ViewModelProvider(this).get(PokemonViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        observeLiveData()

        binding.btLoad.setOnClickListener {
            model.loadData()
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
            binding.tv.text = "${it?.name ?: "-"} ${it?.type ?: "-"}"
        }

        model.runInProgress.observe(this) {
            binding.progressBar.isVisible = it
        }
    }
}