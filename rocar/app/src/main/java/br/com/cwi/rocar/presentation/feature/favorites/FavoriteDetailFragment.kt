package br.com.cwi.rocar.presentation.feature.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.cwi.rocar.databinding.FragmentFavoriteDetailBinding
import br.com.cwi.rocar.presentation.extension.toPhoneFormat
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

var EXTRA_QUERY_CLIENT_ID = 0

class FavoriteDetailFragment() : Fragment() {

    private lateinit var binding: FragmentFavoriteDetailBinding

    private val viewModel: FavoriteViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun setupViewModel() {
        viewModel.clientsFavoritesById.observe(viewLifecycleOwner) { client ->
            binding.tvNameValue.text = client.name
            binding.tvCpfValue.text = client.cpf
            binding.tvStreetValue.text = client.street
            binding.tvNumberValue.text = client.nHome.toString()
            binding.tvCityValue.text = client.city
            binding.tvPhoneValue.text = toPhoneFormat(client.phone)
        }
        viewModel.getClientById(EXTRA_QUERY_CLIENT_ID)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }
}