package br.com.cwi.rocar.presentation.feature.favorites


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.nespresso_app.data.database.entity.ClientEntity
import br.com.cwi.rocar.R
import br.com.cwi.rocar.databinding.FragmentFavoriteBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding

    private val viewModel: FavoriteViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.clientsFavorites.observe(viewLifecycleOwner) { list ->
            setUpClientRecyclerView(list)
        }
        viewModel.fetchClients()
    }


    private fun setUpClientRecyclerView(list: List<ClientEntity>) {

        binding.contentSearch.root.setOnClickListener {
            viewModel.clientsFavorites.observe(viewLifecycleOwner) { listOriginal ->
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
            adapter = FavoriteAdapter(list,
                onClientClick = {
                    navigateToClientDetail(it.id)
                })
        }
    }

    private fun navigateToClientDetail(id: Int) {
        findNavController().navigate(
            R.id.favoriteDetailFragment
        )
        EXTRA_QUERY_CLIENT_ID = id
    }
}