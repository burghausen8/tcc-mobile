package br.com.cwi.rocar.domain.repository

import br.com.cwi.rocar.domain.entity.Client
import br.com.cwi.rocar.domain.entity.Vehicle

interface ClientRepository {
    suspend fun getClients(): List<Client>
    suspend fun getClientById(id: Int): Client
    suspend fun postClient(client: Client)
    suspend fun postVehicle(vehicle: Vehicle)
    suspend fun deleteClient(id: Int)
    suspend fun setClient(client: Client, id: Int)
}