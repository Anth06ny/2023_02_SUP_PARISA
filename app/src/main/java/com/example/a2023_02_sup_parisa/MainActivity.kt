package com.example.a2023_02_sup_parisa

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.a2023_02_sup_parisa.databinding.ActivityMainBinding

const val MENU_ITEM_WEATHER = 1
const val MENU_ITEM_POKEMON = 2

class MainActivity : AppCompatActivity(), View.OnClickListener {


    //Créé une instance du XML
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //affichage
        setContentView(binding.root)



        binding.btValidate.setOnClickListener {

            if (binding.rbLike.isChecked) {
                binding.et.setText(binding.rbLike.text)
            }
            else if (binding.rbDislike.isChecked) {
                binding.et.setText(binding.rbDislike.text)
            }

            binding.iv.setImageResource(R.drawable.baseline_delete_forever_24)
        }

        binding.btCancel.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v == binding.btCancel) {
            binding.et.setText("")
            //Clear radiobutton
            binding.rg.clearCheck()
            binding.iv.setImageResource(R.drawable.baseline_flag_24)
        }
    }

    //Callback de création du menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0, MENU_ITEM_WEATHER, 0, "Météo")
        menu.add(0, MENU_ITEM_POKEMON, 0, "Pokemon")

        return super.onCreateOptionsMenu(menu)
    }

    //Callback des clicks sur les menus
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == MENU_ITEM_WEATHER) {
            val intent = Intent(this, WeatherActivity::class.java)
            //Exo plus rapides passage paramètre
//            intent.putExtra("toto", binding.et.text.toString())
//            intent.putExtra("toto", WindBean(5.0))
            //fin Exo plus rapides passage paramètre
            startActivity(intent)
        }
        else if (item.itemId == MENU_ITEM_POKEMON) {
            val intent = Intent(this, PokemonActivity::class.java)
            //Exo plus rapides passage paramètre
//            intent.putExtra("toto", binding.et.text.toString())
//            intent.putExtra("toto", WindBean(5.0))
            //fin Exo plus rapides passage paramètre
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

}
