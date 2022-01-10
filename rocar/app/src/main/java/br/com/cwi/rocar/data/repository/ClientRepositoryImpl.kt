package br.com.cwi.rocar.data.repository


import br.com.cwi.nespresso_app.data.network.RocarApi
import br.com.cwi.nespresso_app.data.network.entity.ClientResponse
import br.com.cwi.nespresso_app.data.network.mapper.ClientMapper
import br.com.cwi.rocar.domain.entity.Client
import br.com.cwi.rocar.domain.repository.ClientRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.RequestBody
import org.json.JSONObject


class ClientRepositoryImpl(
    private val api: RocarApi,
    private val clientMapper: ClientMapper
) : ClientRepository {

    override suspend fun getClients(): List<Client> {
        return withContext(Dispatchers.IO) {
            clientMapper.toDomain(api.getClients())
        }
    }

    override suspend fun getClientById(id: Int): Client{
        return withContext(Dispatchers.IO) {
            clientMapper.toDomain(api.getClientById(id))
        }
        }

    override suspend fun postClient(client: RequestBody){
       api.postClient(client)
    }
    override suspend fun postVehicle(vehicle: RequestBody){
        api.postVehicle(vehicle)
    }


}