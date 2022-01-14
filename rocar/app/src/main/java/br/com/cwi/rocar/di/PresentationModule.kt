package br.com.cwi.rocar.di

import br.com.cwi.rocar.presentation.feature.initial.query.client.QueryClientViewModel
import br.com.cwi.rocar.presentation.feature.favorites.FavoriteViewModel
import br.com.cwi.rocar.presentation.feature.initial.query.vehicle.QueryVehicleViewModel
import br.com.cwi.rocar.presentation.feature.initial.register.client.RegisterClientViewModel
import br.com.cwi.rocar.presentation.feature.initial.register.vehicle.RegisterVehicleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { QueryClientViewModel(get(), get()) }
    viewModel { QueryVehicleViewModel(get()) }
    viewModel { RegisterClientViewModel(get()) }
    viewModel { RegisterVehicleViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
}