package br.com.cwi.rocar.presentation.feature.favorites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import br.com.cwi.rocar.R
import br.com.cwi.rocar.databinding.ActivityFavoriteHostBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val VIEW_CONTENT = 0
private const val VIEW_LOADING = 1
private const val VIEW_ERROR = 2

class FavoriteHostActivity : AppCompatActivity() {

    private val viewModel: FavoriteViewModel by viewModel()

    private lateinit var binding: ActivityFavoriteHostBinding

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(binding.navHostFavoriteContainer.id) as NavHostFragment)
            .findNavController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteHostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.root.findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        setupViewModel()
        setupNavController()
    }

    private fun setupNavController() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val title = when (destination.id) {
                R.id.favoriteFragment -> "Favoritos"
                else -> "Detalhes"
            }
            supportActionBar?.title = title
        }
    }

    private fun setupViewModel() {
        viewModel.loading.observe(this) { isLoading ->
            binding.vpFavorite.displayedChild = if (isLoading) VIEW_LOADING else VIEW_CONTENT
        }

        viewModel.error.observe(this) { hasError ->
            binding.vpFavorite.displayedChild = if (hasError) VIEW_ERROR else VIEW_CONTENT
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}