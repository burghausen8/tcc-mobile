package br.com.cwi.rocar.presentation.feature.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.nespresso_app.data.database.entity.ClientEntity
import br.com.cwi.rocar.domain.repository.ClientLocalRepository
import br.com.cwi.rocar.presentation.base.BaseViewModel

class FavoriteViewModel(
    private val clientLocalRepository: ClientLocalRepository,
) : BaseViewModel() {

    private val _clientsFavorites = MutableLiveData<List<ClientEntity>>()
    val clientsFavorites: LiveData<List<ClientEntity>> = _clientsFavorites

    private val _clientsFavoritesById = MutableLiveData<ClientEntity>()
    val clientsFavoritesById: LiveData<ClientEntity> = _clientsFavoritesById


    fun getClientById(id: Int) {
        launch {
            val list = clientLocalRepository.getAll()

            val client = list?.takeIf { it.isNotEmpty() }?.let { list ->
                list.find { client ->
                    client.id == id
                }
            }
            _clientsFavoritesById.postValue(client)
        }
    }

    fun fetchClients() {
        launch {
            val list = clientLocalRepository.getAll()
            _clientsFavorites.postValue(list)
        }
    }
}