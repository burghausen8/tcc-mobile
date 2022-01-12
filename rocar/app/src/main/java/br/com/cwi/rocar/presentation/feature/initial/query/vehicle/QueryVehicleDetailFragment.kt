package br.com.cwi.rocar.presentation.feature.initial.query.vehicle

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import br.com.cwi.rocar.R
import br.com.cwi.rocar.databinding.FragmentQueryVehicleDetailBinding
import br.com.cwi.rocar.presentation.extension.toPhoneFormat
import br.com.cwi.rocar.presentation.feature.initial.query.client.EXTRA_QUERY_CLIENT_ID
import br.com.cwi.rocar.presentation.feature.initial.query.client.QueryClientViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

var EXTRA_QUERY_VEHICLE_ID = 0

class QueryVehicleDetailFragment() : Fragment() {

    private lateinit var binding: FragmentQueryVehicleDetailBinding

    private val viewModelVehicle: QueryVehicleViewModel by sharedViewModel()

    private val viewModelClient: QueryClientViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQueryVehicleDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun setupViewModel() {
        viewModelVehicle.vehiclesById.observe(viewLifecycleOwner) { vehicle ->
            binding.tvModelValue.text = (vehicle.brand + "/" + vehicle.model)
            binding.tvYearValue.text = vehicle.year.toString()
            binding.tvBoardValue.text = vehicle.board
            binding.tvColorValue.text = vehicle.color

            viewModelClient.getClientById(vehicle.idProp)

        }

        viewModelClient.clientsById.observe(viewLifecycleOwner) { client ->
            binding.tvNameValue.text = client.name
            binding.tvCpfValue.text = client.cpf
            binding.tvStreetValue.text = client.street
            binding.tvNumberValue.text = client.nHome.toString()
            binding.tvCityValue.text = client.city
            binding.tvPhoneValue.text = toPhoneFormat(client.phone)
        }
        viewModelVehicle.getVehicleById(EXTRA_QUERY_VEHICLE_ID)

        binding.contentDelete.root.setOnClickListener {
            alertDelete()
        }
        binding.contentEdit.root.setOnClickListener {
            navigateToEditVehicle()
        }
    }

    private fun alertDelete(){
        val dialogBuilder = AlertDialog.Builder(binding.root.context)

        dialogBuilder.setMessage("Você realmente deseja excluir?")
            .setCancelable(false)
            .setPositiveButton("Excluir", DialogInterface.OnClickListener {
                    dialog, id -> deleteClient()
            })
            .setNegativeButton("Cancelar", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })

        val alert = dialogBuilder.create()
        alert.show()

    }
    private fun deleteClient(){
        viewModelVehicle.deleteVehicle(EXTRA_QUERY_VEHICLE_ID)

        Toast.makeText(binding.root.context, "Veiculo excluido!", Toast.LENGTH_LONG).show()

        findNavController().navigate(
            R.id.queryVehicleFragment
        )
    }

    private fun navigateToEditVehicle(){
        findNavController().navigate(
            R.id.queryVehicleEditFragment
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }
}