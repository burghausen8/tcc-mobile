package br.com.cwi.nespresso_app.data.network.entity

import com.squareup.moshi.Json

class ClientResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "cpf") val cpf: String?,
    @Json(name = "street") val street: String?,
    @Json(name = "nHome") val nHome: String?,
    @Json(name = "city") val city: String?,
    @Json(name = "phone") val phone: String?,
)
