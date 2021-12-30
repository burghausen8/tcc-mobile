package br.com.cwi.rocar.presentation.feature.initial.query

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cwi.rocar.R
import br.com.cwi.rocar.databinding.ActivityQueryBinding
import br.com.cwi.rocar.databinding.ActivityRegisterBinding
import br.com.cwi.rocar.presentation.feature.initial.query.client.QueryClientHostActivity

class QueryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQueryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQueryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpQueryActions()
    }

    private fun setUpQueryActions() {
        binding.contentClient.root.setOnClickListener {
            val intent = Intent(this, QueryClientHostActivity::class.java)
            startActivity(intent)
        }

        binding.contentVehicle.root.setOnClickListener {
            //  val intent = Intent(this, QueryActivity::class.java)
            //  startActivity(intent)
        }

    }
}