package br.com.cwi.rocar.domain.repository

import br.com.cwi.rocar.domain.entity.Vehicle

interface VehicleRepository {
    suspend fun getVehicles(): List<Vehicle>
    suspend fun getVehicleById(id: Int): Vehicle
    suspend fun deleteVehicle(id: Int)
    suspend fun setVehicle(vehicle: Vehicle, id: Int)
}