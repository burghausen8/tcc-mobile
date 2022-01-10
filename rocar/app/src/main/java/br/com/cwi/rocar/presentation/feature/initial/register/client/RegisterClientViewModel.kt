package br.com.cwi.rocar.presentation.feature.initial.register.client

import androidx.lifecycle.MutableLiveData
import br.com.cwi.nespresso_app.data.network.entity.ClientResponse
import br.com.cwi.nespresso_app.data.network.mapper.ClientMapper
import br.com.cwi.rocar.data.repository.ClientRepositoryImpl
import br.com.cwi.rocar.domain.entity.Client
import br.com.cwi.rocar.domain.repository.ClientRepository
import br.com.cwi.rocar.presentation.base.BaseViewModel
import okhttp3.RequestBody
import org.json.JSONObject

class RegisterClientViewModel(
    private val clientRepository: ClientRepository
) : BaseViewModel() {


    fun postClient( client: RequestBody) {
        launch {
           clientRepository.postClient(client)
        }
    }


}