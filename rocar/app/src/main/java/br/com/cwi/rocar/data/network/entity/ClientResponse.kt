package br.com.cwi.nespresso_app.data.network.entity

import com.squareup.moshi.Json

class ClientResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "nome") val name: String,
    @Json(name = "cpf") val cpf: String?,
    @Json(name = "rua") val street: String?,
    @Json(name = "nCasa") val nHome: Int?,
    @Json(name = "cidade") val city: String?,
)
