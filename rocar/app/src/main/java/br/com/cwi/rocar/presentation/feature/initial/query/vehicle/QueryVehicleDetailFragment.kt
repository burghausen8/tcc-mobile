package br.com.cwi.rocar.presentation.feature.initial.query.vehicle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.cwi.rocar.databinding.FragmentQueryVehicleDetailBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

 var EXTRA_QUERY_VEHICLE_ID = 0

class QueryVehicleDetailFragment (): Fragment() {

    private lateinit var binding: FragmentQueryVehicleDetailBinding

    private val viewModel: QueryVehicleViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQueryVehicleDetailBinding.inflate(layoutInflater)
        return binding.root
    }


    private fun setupViewModel() {
        viewModel.vehiclesById.observe(viewLifecycleOwner) { vehicle ->
           // binding.tvNameValue.text = vehicle.name
           // binding.tvCpfValue.text = vehicle.cpf
            //binding.tvStreetValue.text = vehicle.street
            //binding.tvNumberValue.text = vehicle.nHome.toString()
           // binding.tvCityValue.text = vehicle.city
           // binding.tvPhoneValue.text = toPhoneFormat(vehicle.phone)


        }
        viewModel.getVehicleById(EXTRA_QUERY_VEHICLE_ID)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()





    }

}