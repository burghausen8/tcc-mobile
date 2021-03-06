package br.com.cwi.rocar.presentation.feature.initial.register.client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.cwi.nespresso_app.presentation.extension.visibleOrGone
import br.com.cwi.rocar.R
import br.com.cwi.rocar.databinding.ActivityRegisterClientBinding
import br.com.cwi.rocar.domain.entity.Client
import br.com.cwi.rocar.presentation.extension.RandomNumberGenerator
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class RegisterClientActivity : AppCompatActivity() {

    private val viewModel: RegisterClientViewModel by viewModel()

    private lateinit var binding: ActivityRegisterClientBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterClientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle("Cadastro Cliente")
        setSupportActionBar(binding.root.findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupViewModel()
        setupRegisterCLient()
    }

    private fun setupViewModel() {
        viewModel.loading.observe(this@RegisterClientActivity) { isLoading ->
            binding.viewLoading.root.visibleOrGone(isLoading)
        }

        viewModel.error.observe(this@RegisterClientActivity) { hasError ->
            binding.viewError.root.visibleOrGone(hasError)
        }
    }

    private fun setupRegisterCLient() {

        binding.contentRegister.root.setOnClickListener {

            if (binding.tvNameValue.text.toString().isEmpty()) {
                Toast.makeText(applicationContext, "Nome obrigatório", Toast.LENGTH_LONG).show()
            } else {
                var client = createCLient()

                viewModel.postClient(client)

                Toast.makeText(applicationContext, "Cadastrado com sucesso!", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun createCLient(): Client {
        var client = Client(
            RandomNumberGenerator(),
            binding.tvNameValue.text.toString(),
            binding.tvCpfValue.text.toString(),
            binding.tvStreetValue.text.toString(),
            binding.tvNumberValue.text.toString(),
            binding.tvCityValue.text.toString(),
            binding.tvPhoneValue.text.toString()
        )
        return client
    }
}