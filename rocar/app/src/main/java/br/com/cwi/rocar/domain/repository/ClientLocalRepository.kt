package br.com.cwi.rocar.domain.repository

import br.com.cwi.nespresso_app.data.database.entity.ClientEntity

interface ClientLocalRepository {
    fun add(clientEntity: ClientEntity)
    fun remove(clientEntity: ClientEntity)
    fun getAll(): List<ClientEntity>?
}