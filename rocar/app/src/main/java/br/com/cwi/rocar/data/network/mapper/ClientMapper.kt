package br.com.cwi.nespresso_app.data.network.mapper

import br.com.cwi.nespresso_app.data.network.entity.ClientResponse

import br.com.cwi.rocar.domain.entity.Client

class ClientMapper: DomainMapper<ClientResponse, Client> {

    override fun toDomain(from: ClientResponse) = Client(
        id = from.id,
        name = from.name,
        cpf = from.cpf,
        street = from.street,
        nHome = from.nHome,
        city = from.city,
        phone = from.phone,
    )


    override fun toDomain(from: List<ClientResponse>) = from.map {
        toDomain(it)
    }
}