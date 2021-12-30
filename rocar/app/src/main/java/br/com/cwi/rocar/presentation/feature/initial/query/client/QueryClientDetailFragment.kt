package br.com.cwi.rocar.presentation.feature.initial.query.client

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.cwi.rocar.databinding.FragmentQueryClientBinding
import br.com.cwi.rocar.databinding.FragmentQueryClientDetailBinding

const val EXTRA_QUERY_CLIENT_ID = "EXTRA_QUERY_CLIENT_ID"

class QueryClientDetailFragment : Fragment() {

    private lateinit var binding: FragmentQueryClientDetailBinding

    private val coffeeId by lazy {
        arguments?.getInt(EXTRA_QUERY_CLIENT_ID)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQueryClientDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvBatata.text = coffeeId.toString()
    }

}