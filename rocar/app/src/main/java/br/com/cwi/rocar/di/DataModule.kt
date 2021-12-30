package br.com.cwi.rocar.di

import br.com.cwi.nespresso_app.data.network.RetrofitConfig
import br.com.cwi.nespresso_app.data.network.mapper.ClientMapper
import br.com.cwi.rocar.data.database.AppDatabase
import br.com.cwi.rocar.data.repository.ClientRepositoryImpl
import br.com.cwi.rocar.domain.repository.ClientRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    single { RetrofitConfig.service }

    single { ClientMapper() }
    single { AppDatabase.create(androidApplication()) }

    factory<ClientRepository> { ClientRepositoryImpl(get(), get()) }

}