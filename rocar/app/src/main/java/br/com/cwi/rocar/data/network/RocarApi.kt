package br.com.cwi.nespresso_app.data.network

import br.com.cwi.nespresso_app.data.network.entity.ClientResponse
import retrofit2.http.GET

interface RocarApi {

    @GET("/clientes")
    suspend fun getClients(): List<ClientResponse>


}