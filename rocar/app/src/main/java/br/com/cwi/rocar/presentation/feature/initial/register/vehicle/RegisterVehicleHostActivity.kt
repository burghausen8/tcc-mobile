package br.com.cwi.rocar.presentation.feature.initial.register.vehicle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import br.com.cwi.rocar.R
import br.com.cwi.rocar.databinding.ActivityRegisterVehicleHostBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val VIEW_CONTENT = 0
private const val VIEW_LOADING = 1
private const val VIEW_ERROR = 2

class RegisterVehicleHostActivity : AppCompatActivity() {

    private val viewModel: RegisterVehicleViewModel by viewModel()

    private lateinit var binding : ActivityRegisterVehicleHostBinding

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(binding.navHostRegisterVehicleContainer.id) as NavHostFragment)
            .findNavController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterVehicleHostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupViewModel()
        setupNavController()
    }

    private fun setupNavController() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val title = when (destination.id) {
                R.id.registerVehicleFragment -> "Selecione o Proprietario"
                else -> "Cadastro Veiculo"
            }
            supportActionBar?.title = title
        }
    }

    private fun setupViewModel() {
        viewModel.loading.observe(this) { isLoading ->
            binding.vpRegisterVehicle.displayedChild = if (isLoading) VIEW_LOADING else VIEW_CONTENT
        }

        viewModel.error.observe(this) { hasError ->
            binding.vpRegisterVehicle.displayedChild = if (hasError) VIEW_ERROR else VIEW_CONTENT
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}