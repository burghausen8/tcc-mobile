package br.com.cwi.rocar.presentation.feature.initial.query.client

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.rocar.domain.entity.Client
import br.com.cwi.rocar.domain.repository.ClientRepository
import br.com.cwi.rocar.presentation.base.BaseViewModel

class QueryClientViewModel(
    private val clientRepository: ClientRepository
) : BaseViewModel() {

    private val _clients = MutableLiveData<List<Client>>()
    val clients: LiveData<List<Client>> = _clients


    fun fetchClients() {
        launch {
            val list = clientRepository.getClients()
            _clients.postValue(list)
        }
    }


}