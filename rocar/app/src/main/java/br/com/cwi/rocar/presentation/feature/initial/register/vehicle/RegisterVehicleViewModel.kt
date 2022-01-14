package br.com.cwi.rocar.presentation.feature.initial.register.vehicle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.rocar.domain.entity.Client
import br.com.cwi.rocar.domain.entity.Vehicle
import br.com.cwi.rocar.domain.repository.ClientRepository
import br.com.cwi.rocar.presentation.base.BaseViewModel

class RegisterVehicleViewModel(
    private val clientRepository: ClientRepository
) : BaseViewModel() {

    private val _clients = MutableLiveData<List<Client>>()
    val clients: LiveData<List<Client>> = _clients

    private val _clientsById = MutableLiveData<Client>()
    val clientsById: LiveData<Client> = _clientsById

    fun getClientById(id: Int) {
        launch {
            val list = clientRepository.getClientById(id)
            _clientsById.postValue(list)
        }
    }

    fun fetchClients() {
        launch {
            val list = clientRepository.getClients()
            _clients.postValue(list)
        }
    }

    fun postVehicle(vehicle: Vehicle) {
        launch {
            clientRepository.postVehicle(vehicle)
        }
    }
}