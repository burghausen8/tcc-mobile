package br.com.cwi.rocar.presentation.feature.initial.register.client


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.cwi.nespresso_app.presentation.extension.visibleOrGone
import br.com.cwi.rocar.databinding.ActivityRegisterClientBinding
import br.com.cwi.rocar.domain.entity.Client
import br.com.cwi.rocar.presentation.extension.RandomNumberGenerator
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class RegisterClientActivity : AppCompatActivity() {

    private val viewModel: RegisterClientViewModel by viewModel()

    private lateinit var binding: ActivityRegisterClientBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterClientBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
                    var client = createCLientRequestBody()

                    viewModel.postClient(client)

                Toast.makeText(applicationContext, "Cadastrado com sucesso!", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun createCLientRequestBody(): Client {
        var client = Client(
            RandomNumberGenerator(),
            binding.tvNameValue.text.toString(),
            binding.tvCpfValue.text.toString(),
            binding.tvStreetValue.text.toString(),
            binding.tvNumberValue.text.toString(),
            binding.tvCityValue.text.toString(),
            binding.tvPhoneValue.text.toString()
        )

        val jsonObject = JSONObject()
        jsonObject.put("id", client.id)
        jsonObject.put("nome", client.name)
        jsonObject.put("cpf", client.cpf)
        jsonObject.put("rua", client.street)
        jsonObject.put("nCasa", client.nHome)
        jsonObject.put("cidade", client.city)
        jsonObject.put("telefone", client.phone)

        val clientRequestBody =
            jsonObject.toString().toRequestBody("application/json".toMediaTypeOrNull())

        return client
    }
}