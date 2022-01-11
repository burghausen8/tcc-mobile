package br.com.cwi.rocar.presentation.feature.initial.register.vehicle


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.rocar.R
import br.com.cwi.rocar.databinding.FragmentRegisterVehicleBinding
import br.com.cwi.rocar.domain.entity.Client
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class RegisterVehicleFragment : Fragment() {

    private lateinit var binding: FragmentRegisterVehicleBinding

    private val viewModel: RegisterVehicleViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterVehicleBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.clients.observe(viewLifecycleOwner) { list ->
            setUpClientRecyclerView(list)
        }
        viewModel.fetchClients()
    }


    private fun setUpClientRecyclerView(list: List<Client>) {

            binding.contentSearch.root.setOnClickListener{
            viewModel.clients.observe(viewLifecycleOwner) { listOriginal ->
                var filter = binding.etSearch.text
                var newList = listOriginal.filter {client -> client.name.contains(filter.toString())}
                setUpClientRecyclerView(newList)
            }
        }

        binding.rvClients.apply {
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
            adapter = RegisterVehicletAdapter(list,
            onClientClick = {
                navigateToClientDetail(it.id)
            })
        }
    }

    private fun navigateToClientDetail(id: Int) {
        findNavController().navigate(
            R.id.registerVehicleDetailFragment
        )
        EXTRA_REGISTER_VEHICLE_ID = id
    }
}