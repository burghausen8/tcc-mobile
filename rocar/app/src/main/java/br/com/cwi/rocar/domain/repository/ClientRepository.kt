package br.com.cwi.rocar.domain.repository

import br.com.cwi.rocar.domain.entity.Client


interface ClientRepository {
    suspend fun getClients(): List<Client>
    suspend fun getClientById(id: Int) : Client

}