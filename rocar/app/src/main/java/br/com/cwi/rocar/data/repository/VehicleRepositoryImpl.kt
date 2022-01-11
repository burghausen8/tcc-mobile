package br.com.cwi.rocar.data.repository


import br.com.cwi.nespresso_app.data.network.RocarApi
import br.com.cwi.nespresso_app.data.network.mapper.VehicleMapper
import br.com.cwi.rocar.domain.entity.Vehicle
import br.com.cwi.rocar.domain.repository.VehicleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class VehicleRepositoryImpl(
    private val api: RocarApi,
    private val vehicleMapper: VehicleMapper
) : VehicleRepository {

    override suspend fun getVehicles(): List<Vehicle> {
        return withContext(Dispatchers.IO) {
            vehicleMapper.toDomain(api.getVehicles())
        }
    }

    override suspend fun getVehicleById(id: Int): Vehicle {
        return withContext(Dispatchers.IO) {
            vehicleMapper.toDomain(api.getVehicleById(id))
        }
    }
}