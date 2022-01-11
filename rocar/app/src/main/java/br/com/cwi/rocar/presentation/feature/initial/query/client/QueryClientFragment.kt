package br.com.cwi.rocar.presentation.feature.initial.query.client

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.rocar.R
import br.com.cwi.rocar.databinding.FragmentQueryClientBinding
import br.com.cwi.rocar.domain.entity.Client
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

        binding.contentSearch.root.setOnClickListener {
            viewModel.clients.observe(viewLifecycleOwner) { listOriginal ->
                var filter = binding.etSearch.text
                var newList =
                    listOriginal.filter { client -> client.name.contains(filter.toString()) }
                setUpClientRecyclerView(newList)
            }
        }

        binding.rvClients.apply {
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
            adapter = QueryClientAdapter(list,
                onClientClick = {
                    navigateToClientDetail(it.id)
                }, onFavoriteClick = {
                    viewModel.setFavorite(it)
                })
        }
    }

    private fun navigateToClientDetail(id: Int) {
        findNavController().navigate(
            R.id.queryClientDetailFragment
        )
        EXTRA_QUERY_CLIENT_ID = id
    }
}