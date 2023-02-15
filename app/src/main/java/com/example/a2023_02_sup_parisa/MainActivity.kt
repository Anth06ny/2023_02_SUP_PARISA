package com.example.a2023_02_sup_parisa

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.a2023_02_sup_parisa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //Créé une instance du XML
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //affichage
        setContentView(binding.root)

        binding.btValidate.setOnClickListener {
            binding.et.setText("Clic sur valider")
            binding.imageView.setImageResource(R.drawable.baseline_delete_forever_24)
        }

        binding.btCancel.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v == binding.btCancel) {
            binding.et.setText("Clic sur annuler")
        }
    }
}
