package br.com.cwi.nespresso_app.data.network.entity

import com.squareup.moshi.Json

class VehicleResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "idProp") val idProp: Int,
    @Json(name = "brand") val brand: String?,
    @Json(name = "model") val model: String,
    @Json(name = "year") val year: Int?,
    @Json(name = "board") val board: String,
    @Json(name = "color") val color: String?,
)
