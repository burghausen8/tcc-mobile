package br.com.cwi.nespresso_app.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import br.com.cwi.rocar.data.database.MeasuresConverter

@Entity
data class ClientEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val cpf: String?,
    val street: String?,
    val nHome: String?,
    val city: String?,
    val phone: String?,
)