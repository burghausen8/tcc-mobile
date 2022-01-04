package br.com.cwi.rocar.presentation.feature.initial.query.vehicle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.rocar.domain.entity.Vehicle
import br.com.cwi.rocar.domain.repository.VehicleRepository
import br.com.cwi.rocar.presentation.base.BaseViewModel

class QueryVehicleViewModel(
    private val vehicleRepository: VehicleRepository
) : BaseViewModel() {

    private val _vehicle = MutableLiveData<List<Vehicle>>()
    val vehicle: LiveData<List<Vehicle>> = _vehicle

    private val _vehiclesById = MutableLiveData<Vehicle>()
    val vehiclesById: LiveData<Vehicle> = _vehiclesById


     fun getVehicleById(id :Int ){
         launch {
             val list = vehicleRepository.getVehicleById(id)
             _vehiclesById.postValue(list)
         }
    }

    fun fetchVehicles() {
        launch {
            val list = vehicleRepository.getVehicles()
            _vehicle.postValue(list)
        }
    }


}