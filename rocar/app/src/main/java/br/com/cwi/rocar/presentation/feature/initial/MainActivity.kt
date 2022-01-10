package br.com.cwi.rocar.presentation.feature.initial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cwi.rocar.R
import br.com.cwi.rocar.databinding.ActivityMainBinding
import br.com.cwi.rocar.presentation.feature.favorites.FavoriteHostActivity
import br.com.cwi.rocar.presentation.feature.initial.query.QueryActivity
import br.com.cwi.rocar.presentation.feature.initial.register.RegisterActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpInitialActions()
    }

    private fun setUpInitialActions() {
        binding.contentRegister.root.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.contentQuery.root.setOnClickListener {
            val intent = Intent(this, QueryActivity::class.java)
            startActivity(intent)
        }

        binding.contentFavorites.root.setOnClickListener {
            val intent = Intent(this, FavoriteHostActivity::class.java)
            startActivity(intent)


        }
    }
}