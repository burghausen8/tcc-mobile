package br.com.cwi.rocar.presentation.feature.initial.query.client

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.rocar.R
import br.com.cwi.rocar.databinding.FragmentQueryClientBinding
import br.com.cwi.rocar.domain.entity.Client
import br.com.cwi.rocar.presentation.feature.initial.query.client.EXTRA_QUERY_CLIENT_ID
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class QueryClientFragment : Fragment() {

    private lateinit var binding: FragmentQueryClientBinding

    private val viewModel: QueryClientViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQueryClientBinding.inflate(layoutInflater)
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
        binding.rvCaps.apply {
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
            adapter = QueryClientAdapter(list,
            onClientClick = {
                navigateToCoffeeDetail(it.id)
            })
        }
    }

    private fun navigateToCoffeeDetail(id: Int) {
        findNavController().navigate(
            R.id.queryClientDetailFragment,
            bundleOf(
                Pair(EXTRA_QUERY_CLIENT_ID, id)
            )
        )
    }
}