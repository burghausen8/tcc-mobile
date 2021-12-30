package br.com.cwi.rocar.presentation.feature.initial.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cwi.rocar.R
import br.com.cwi.rocar.databinding.ActivityMainBinding
import br.com.cwi.rocar.databinding.ActivityRegisterBinding
import br.com.cwi.rocar.presentation.feature.initial.query.QueryActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRegisterActions()
    }

    private fun setUpRegisterActions() {
        binding.contentClient.root.setOnClickListener {
            //val intent = Intent(this, RegisterActivity::class.java)
            //startActivity(intent)
        }

        binding.contentVehicle.root.setOnClickListener {
          //  val intent = Intent(this, QueryActivity::class.java)
          //  startActivity(intent)
        }

    }
}