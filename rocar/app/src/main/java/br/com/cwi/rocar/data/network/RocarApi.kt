package br.com.cwi.nespresso_app.data.network

import br.com.cwi.nespresso_app.data.network.entity.ClientResponse
import br.com.cwi.nespresso_app.data.network.entity.VehicleResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RocarApi {

    @GET("/clientes")
    suspend fun getClients(): List<ClientResponse>

    @GET("/clientes/{id}")
    suspend fun getClientById(@Path("id") id : Int) : ClientResponse

    @GET("/veiculos")
    suspend fun getVehicles(): List<VehicleResponse>

    @GET("/veiculos/{id}")
    suspend fun getVehicleById(@Path("id") id : Int) : VehicleResponse

}