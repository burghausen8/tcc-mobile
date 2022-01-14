package br.com.cwi.rocar.presentation.feature.initial.query.vehicle

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import br.com.cwi.rocar.R
import br.com.cwi.rocar.databinding.FragmentQueryVehicleEditBinding
import br.com.cwi.rocar.domain.entity.Vehicle
import br.com.cwi.rocar.presentation.feature.initial.query.client.QueryClientViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import android.widget.ArrayAdapter
import android.widget.ListView

class QueryVehicleEditFragment() : Fragment() {

    private lateinit var binding: FragmentQueryVehicleEditBinding

    private val viewModelVehicle: QueryVehicleViewModel by sharedViewModel()

    private val viewModelClient: QueryClientViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQueryVehicleEditBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun setupViewModel() {
        viewModelVehicle.vehiclesById.observe(viewLifecycleOwner) { vehicle ->
            binding.tvIdClientValue.setText(vehicle.idProp.toString())
            binding.tvIdVehicleValue.setText(vehicle.id.toString())
            binding.tvBrandValue.setText(vehicle.brand)
            binding.tvModelValue.setText(vehicle.model)
            binding.tvYearValue.setText(vehicle.year.toString())
            binding.tvBoardValue.setText(vehicle.board)
            binding.tvColorValue.setText(vehicle.color)

            viewModelClient.getClientById(vehicle.idProp)
        }

        viewModelClient.clientsById.observe(viewLifecycleOwner) { client ->
            binding.tvNameValue.text = client.name
        }
        viewModelVehicle.getVehicleById(EXTRA_QUERY_VEHICLE_ID)

        binding.contentSave.root.setOnClickListener {
            setVehicle()
        }


        binding.tvNameValue.setOnClickListener {

            val builder = AlertDialog.Builder(binding.root.context)
            builder.setTitle("Selecione o propietario")

            val modeList = ListView(binding.root.context)
            val stringArray = arrayOf("João", "Casimiro")
            val modeAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
                binding.root.context,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                stringArray
            )
            modeList.setAdapter(modeAdapter)

            builder.setView(modeList)
            val dialog: Dialog = builder.create()

            dialog.show()
        }
    }

    private fun setVehicle() {
        var vehicle = createVehicle()

        viewModelVehicle.setVehicle(vehicle)

        Toast.makeText(binding.root.context, "Alterações salvas", Toast.LENGTH_LONG).show()

        navigateToVehicleDetail()
    }

    private fun createVehicle(): Vehicle {
        var vehicle = Vehicle(
            binding.tvIdVehicleValue.text.toString().toInt(),
            binding.tvIdClientValue.text.toString().toInt(),
            binding.tvBrandValue.text.toString(),
            binding.tvModelValue.text.toString(),
            binding.tvYearValue.text.toString().toInt(),
            binding.tvBoardValue.text.toString(),
            binding.tvColorValue.text.toString()
        )
        return vehicle
    }

    private fun navigateToVehicleDetail() {
        findNavController().navigate(
            R.id.queryVehicleDetailFragment
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }
}