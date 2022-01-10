package br.com.cwi.rocar.presentation.feature.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.nespresso_app.data.database.entity.ClientEntity
import br.com.cwi.rocar.data.database.mapper.toClient
import br.com.cwi.rocar.data.database.mapper.toEntity
import br.com.cwi.rocar.domain.entity.Client
import br.com.cwi.rocar.domain.repository.ClientLocalRepository
import br.com.cwi.rocar.domain.repository.ClientRepository
import br.com.cwi.rocar.presentation.base.BaseViewModel

class FavoriteViewModel(
    private val clientLocalRepository: ClientLocalRepository,
    private val clientRepository: ClientRepository,
) : BaseViewModel() {

    private val _clients = MutableLiveData<List<Client>>()
    val clients: LiveData<List<Client>> = _clients

    private val _clientsById = MutableLiveData<Client>()
    val clientsById: LiveData<Client> = _clientsById


     fun getClientById(id :Int ){
         launch {
             val list = clientRepository.getClientById(id)
             _clientsById.postValue(list)
         }
    }

    fun fetchClients() {
        launch {
            val list = clientRepository.getClients()
            _clients.postValue((list))
        }
    }
    private fun getClientsFavorite(clientsList: List<ClientEntity>) {
        val clients : List<Client>

       clientsList.forEach { client ->
           // clients[index] = client
        }

        return
    }


    fun setFavorite(client: Client) {
        val clientEntity = client.toEntity()
        if (client.isFavorite) clientLocalRepository.add(clientEntity)
        else clientLocalRepository.remove(clientEntity)
    }


}