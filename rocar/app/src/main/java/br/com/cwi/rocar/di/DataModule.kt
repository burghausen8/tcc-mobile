package br.com.cwi.rocar.di

import br.com.cwi.nespresso_app.data.network.RetrofitConfig
import br.com.cwi.nespresso_app.data.network.mapper.ClientMapper
import br.com.cwi.nespresso_app.data.network.mapper.VehicleMapper
import br.com.cwi.rocar.data.database.AppDatabase
import br.com.cwi.rocar.data.repository.ClientRepositoryImpl
import br.com.cwi.rocar.data.repository.VehicleRepositoryImpl
import br.com.cwi.rocar.domain.repository.ClientRepository
import br.com.cwi.rocar.domain.repository.VehicleRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    single { RetrofitConfig.service }

    single { ClientMapper() }
    single {VehicleMapper()}
    single { AppDatabase.create(androidApplication()) }

    factory<ClientRepository> { ClientRepositoryImpl(get(), get()) }
    factory<VehicleRepository> { VehicleRepositoryImpl(get(), get()) }

}