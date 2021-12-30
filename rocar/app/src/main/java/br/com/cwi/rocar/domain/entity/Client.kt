package br.com.cwi.rocar.domain.entity

class Client(
    var id: Int,
    var name: String,
    var cpf: String?,
    var street: String?,
    var nHome: Int?,
    var city: String?
)