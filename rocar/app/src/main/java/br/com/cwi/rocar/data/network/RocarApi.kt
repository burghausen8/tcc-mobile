package br.com.cwi.nespresso_app.data.network

import br.com.cwi.nespresso_app.data.network.entity.ClientResponse
import br.com.cwi.nespresso_app.data.network.entity.VehicleResponse
import br.com.cwi.rocar.domain.entity.Client
import br.com.cwi.rocar.domain.entity.Vehicle
import okhttp3.RequestBody
import retrofit2.http.*

interface RocarApi {

    @GET("/clientes")
    suspend fun getClients(): List<ClientResponse>

    @GET("/clientes/{id}")
    suspend fun getClientById(@Path("id") id : Int) : ClientResponse

    @POST("/clientes")
    suspend fun postClient(@Body client: Client)

    @DELETE("/clientes/{id}")
    suspend fun deleteClient(@Path("id") id : Int)

    @POST("/veiculos")
    suspend fun postVehicle(@Body vehicle: Vehicle)

    @GET("/veiculos")
    suspend fun getVehicles(): List<VehicleResponse>

    @GET("/veiculos/{id}")
    suspend fun getVehicleById(@Path("id") id : Int) : VehicleResponse
}