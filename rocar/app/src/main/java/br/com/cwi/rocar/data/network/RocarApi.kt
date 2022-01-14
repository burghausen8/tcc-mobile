package br.com.cwi.nespresso_app.data.network

import br.com.cwi.nespresso_app.data.network.entity.ClientResponse
import br.com.cwi.nespresso_app.data.network.entity.VehicleResponse
import br.com.cwi.rocar.domain.entity.Client
import br.com.cwi.rocar.domain.entity.Vehicle
import retrofit2.http.*

interface RocarApi {

    @GET("/clientes")
    suspend fun getClients(): List<ClientResponse>

    @GET("/clientes/{id}")
    suspend fun getClientById(@Path("id") id: Int): ClientResponse

    @POST("/clientes")
    suspend fun postClient(@Body client: Client)

    @DELETE("/clientes/{id}")
    suspend fun deleteClient(@Path("id") id: Int)

    @PUT("/clientes/{id}")
    suspend fun setClient(@Body client: Client, @Path("id") id: Int)

    @POST("/veiculos")
    suspend fun postVehicle(@Body vehicle: Vehicle)

    @GET("/veiculos")
    suspend fun getVehicles(): List<VehicleResponse>

    @DELETE("/veiculos/{id}")
    suspend fun deleteVehicle(@Path("id") id: Int)

    @GET("/veiculos/{id}")
    suspend fun getVehicleById(@Path("id") id: Int): VehicleResponse

    @PUT("/veiculos/{id}")
    suspend fun setVehicle(@Body vehicle: Vehicle, @Path("id") id: Int)
}