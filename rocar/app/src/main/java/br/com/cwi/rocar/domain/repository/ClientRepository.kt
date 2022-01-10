package br.com.cwi.rocar.domain.repository

import br.com.cwi.nespresso_app.data.network.entity.ClientResponse
import br.com.cwi.rocar.domain.entity.Client
import okhttp3.RequestBody
import org.json.JSONObject


interface ClientRepository {
    suspend fun getClients(): List<Client>
    suspend fun getClientById(id: Int) : Client
    suspend fun postClient(client : RequestBody)
    suspend fun postVehicle( vehicle: RequestBody)

}