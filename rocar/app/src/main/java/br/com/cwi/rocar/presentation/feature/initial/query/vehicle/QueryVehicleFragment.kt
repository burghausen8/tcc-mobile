package br.com.cwi.rocar.presentation.feature.initial.query.vehicle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.rocar.R
import br.com.cwi.rocar.databinding.FragmentQueryVehicleBinding
import br.com.cwi.rocar.domain.entity.Vehicle
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class QueryVehicleFragment : Fragment() {

    private lateinit var binding: FragmentQueryVehicleBinding

    private val viewModel: QueryVehicleViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQueryVehicleBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.vehicle.observe(viewLifecycleOwner) { list ->
            setUpVehicleRecyclerView(list)
        }
        viewModel.fetchVehicles()
    }


    private fun setUpVehicleRecyclerView(list: List<Vehicle>) {

        binding.contentSearch.root.setOnClickListener {
            viewModel.vehicle.observe(viewLifecycleOwner) { listOriginal ->
                var filter = binding.etSearch.text
                var newList = listOriginal.filter { vehicle ->
                    vehicle.board.contains(filter.toString()) || vehicle.model.contains(filter.toString())
                }
                setUpVehicleRecyclerView(newList)
            }
        }

        binding.rvVehicles.apply {
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
            adapter = QueryVehicleAdapter(list,
                onVehicleClick = {
                    navigateToVehicleDetail(it.id)
                })
        }
    }

    private fun navigateToVehicleDetail(id: Int) {
        findNavController().navigate(
            R.id.queryVehicleDetailFragment
        )
        EXTRA_QUERY_VEHICLE_ID = id
    }
}