package br.com.cwi.rocar.presentation.feature.initial.query.client

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import br.com.cwi.rocar.R
import br.com.cwi.rocar.databinding.FragmentQueryClientEditBinding
import br.com.cwi.rocar.domain.entity.Client
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class QueryClientEditFragment() : Fragment() {

    private lateinit var binding: FragmentQueryClientEditBinding

    private val viewModel: QueryClientViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQueryClientEditBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun setupViewModel() {
        viewModel.clientsById.observe(viewLifecycleOwner) { client ->
            binding.tvIdClientValue.setText(client.id.toString())
            binding.tvNameValue.setText(client.name)
            binding.tvCpfValue.setText(client.cpf)
            binding.tvStreetValue.setText(client.street)
            binding.tvNumberValue.setText(client.nHome.toString())
            binding.tvCityValue.setText(client.city)
            binding.tvPhoneValue.setText(client.phone)
        }
        viewModel.getClientById(EXTRA_QUERY_CLIENT_ID)

        binding.contentSave.root.setOnClickListener {
            setClient()
        }
    }

    private fun setClient() {
        var client = createCLient()

        viewModel.setClient(client)

        Toast.makeText(binding.root.context, "Alterações salvas", Toast.LENGTH_LONG).show()

        navigateToClientDetail()
    }

    private fun createCLient(): Client {
        var client = Client(
            binding.tvIdClientValue.text.toString().toInt(),
            binding.tvNameValue.text.toString(),
            binding.tvCpfValue.text.toString(),
            binding.tvStreetValue.text.toString(),
            binding.tvNumberValue.text.toString(),
            binding.tvCityValue.text.toString(),
            binding.tvPhoneValue.text.toString()
        )
        return client
    }

    private fun navigateToClientDetail() {
        findNavController().navigate(
            R.id.queryClientDetailFragment
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }
}