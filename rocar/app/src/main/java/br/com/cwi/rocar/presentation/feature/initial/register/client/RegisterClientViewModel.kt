package br.com.cwi.rocar.presentation.feature.initial.register.client


import br.com.cwi.rocar.domain.entity.Client
import br.com.cwi.rocar.domain.repository.ClientRepository
import br.com.cwi.rocar.presentation.base.BaseViewModel

class RegisterClientViewModel(
    private val clientRepository: ClientRepository
) : BaseViewModel() {

    fun postClient(client: Client) {
        launch {
            clientRepository.postClient(client)
        }
    }
}