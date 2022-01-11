package br.com.cwi.rocar.presentation.feature.initial.register.vehicle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.cwi.rocar.databinding.FragmentRegisterVehicleDetailBinding
import br.com.cwi.rocar.domain.entity.Vehicle
import br.com.cwi.rocar.presentation.extension.RandomNumberGenerator
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

 var EXTRA_REGISTER_VEHICLE_ID = 0

class RegisterVehicleDetailFragment (): Fragment() {

    private lateinit var binding: FragmentRegisterVehicleDetailBinding

    private val viewModel: RegisterVehicleViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterVehicleDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun setupViewModel() {
        viewModel.clientsById.observe(viewLifecycleOwner) { client ->
            binding.tvNameValue.text = client.name
            binding.tvIdClientValue.text = client.id.toString()

            setupRegisterCLient()
        }
        viewModel.getClientById(EXTRA_REGISTER_VEHICLE_ID)
    }

    private fun setupRegisterCLient() {

        binding.contentRegister.root.setOnClickListener {

            if (binding.tvModelValue.text.toString().isEmpty() || binding.tvBoardValue.text.toString().isEmpty()) {
                Toast.makeText(binding.root.context, "Modelo e Placa obrigatórios!", Toast.LENGTH_LONG).show()
            } else {
                var vehicle = createVehicle()

                viewModel.postVehicle(vehicle)
                Toast.makeText(binding.root.context, "Cadastrado com sucesso!", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun createVehicle(): Vehicle {
        var vehicle = Vehicle(
            RandomNumberGenerator(),
            binding.tvIdClientValue.text.toString().toInt(),
            binding.tvBrandValue.text.toString(),
            binding.tvModelValue.text.toString(),
            binding.tvYearValue.text.toString().toInt(),
            binding.tvBoardValue.text.toString(),
            binding.tvColorValue.text.toString()
        )
        return vehicle
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }
}