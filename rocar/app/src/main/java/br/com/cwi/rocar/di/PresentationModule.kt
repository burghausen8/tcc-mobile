package br.com.cwi.rocar.di


import br.com.cwi.rocar.presentation.feature.initial.query.client.QueryClientViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { QueryClientViewModel(get()) }

}