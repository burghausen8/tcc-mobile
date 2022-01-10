package br.com.cwi.rocar.data.repository

import br.com.cwi.nespresso_app.data.database.entity.ClientEntity
import br.com.cwi.rocar.data.database.AppDatabase
import br.com.cwi.rocar.domain.repository.ClientLocalRepository

class ClientLocalRepositoryImpl(
    appDatabase: AppDatabase
) : ClientLocalRepository {

    private val dao = appDatabase.getClientDao()

    override fun add(clientEntity: ClientEntity) {
        dao.add(clientEntity)
    }

    override fun remove(clientEntity: ClientEntity) {
        dao.remove(clientEntity)
    }

    override fun getAll(): List<ClientEntity>? = dao.getAll()
}