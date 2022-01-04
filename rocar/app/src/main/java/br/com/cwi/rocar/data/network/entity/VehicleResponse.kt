package br.com.cwi.nespresso_app.data.network.entity

import com.squareup.moshi.Json

class VehicleResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "idProp") val idProp: Int,
    @Json(name = "marca") val brand: String?,
    @Json(name = "modelo") val model: String?,
    @Json(name = "ano") val year: Int?,
    @Json(name = "placa") val board: String,
    @Json(name = "cor") val color: String?,

)
