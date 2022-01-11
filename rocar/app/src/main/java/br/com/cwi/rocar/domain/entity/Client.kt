package br.com.cwi.rocar.domain.entity

data class Client(
    var id: Int,
    var name: String,
    var cpf: String?,
    var street: String?,
    var nHome: String?,
    var city: String?,
    var phone: String?,
    var isFavorite: Boolean = false
)