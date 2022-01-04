package br.com.cwi.nespresso_app.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class VehicleEntity(
    @PrimaryKey val id: Int,
    val idProp: Int,
    val brand: String?,
    val model: String?,
    val year: Int?,
    val board: String,
    val color: String?
)