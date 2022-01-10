package br.com.cwi.nespresso_app.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.cwi.nespresso_app.data.database.entity.ClientEntity

@Dao
interface ClientDao {

    @Insert
    fun add(clientEntity: ClientEntity)

    @Delete
    fun remove(clientEntity: ClientEntity)

    @Query("SELECT * FROM ClientEntity")
    fun getAll(): List<ClientEntity>?
}