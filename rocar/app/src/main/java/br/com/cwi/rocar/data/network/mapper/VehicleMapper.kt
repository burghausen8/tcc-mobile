package br.com.cwi.nespresso_app.data.network.mapper


import br.com.cwi.nespresso_app.data.network.entity.VehicleResponse
import br.com.cwi.rocar.domain.entity.Vehicle

class VehicleMapper: DomainMapper<VehicleResponse, Vehicle> {

    override fun toDomain(from: VehicleResponse) = Vehicle(
        id = from.id,
        idProp = from.idProp,
        brand = from.brand ,
        model = from.model,
        year = from.year,
        board = from.board,
        color = from.color
    )

    override fun toDomain(from: List<VehicleResponse>) = from.map {
        toDomain(it)
    }
}