package br.com.cwi.rocar.presentation.feature.initial.query.client

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.rocar.data.database.mapper.toEntity
import br.com.cwi.rocar.domain.entity.Client
import br.com.cwi.rocar.domain.repository.ClientLocalRepository
import br.com.cwi.rocar.domain.repository.ClientRepository
import br.com.cwi.rocar.presentation.base.BaseViewModel

class QueryClientViewModel(
    private val clientRepository: ClientRepository,
    private val clientLocalRepository: ClientLocalRepository
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
            _clients.postValue(getClientsFavorite(list))
        }
    }
    private fun getClientsFavorite(clientsList: List<Client>): List<Client> {
        val favoriteList = clientLocalRepository.getAll()

        clientsList.forEach { client ->
            favoriteList?.takeIf { it.isNotEmpty() }?.let { favoriteList ->
                favoriteList.forEach { clientFavoriteList ->
                    if (client.id == clientFavoriteList.id){
                        client.isFavorite = true
                    }
                }}
        }
        return clientsList
    }

    fun deleteClient(id : Int){
        launch {
            removeClientFavorite(id)
            clientRepository.deleteClient(id)
        }
    }

    fun setFavorite(client: Client) {
        val clientEntity = client.toEntity()
        if (client.isFavorite) clientLocalRepository.add(clientEntity)
        else clientLocalRepository.remove(clientEntity)
    }

    private fun removeClientFavorite(id: Int){
        val favoriteList = clientLocalRepository.getAll()
        favoriteList?.takeIf { it.isNotEmpty() }?.let { favoriteList ->
            favoriteList.forEach { clientFavorite ->
                if (id == clientFavorite.id){
                    clientLocalRepository.remove(clientFavorite)
                }
            }
        }
    }

    fun setClient(client : Client) {
        launch {
            clientRepository.setClient(client, client.id)
        }
    }
}