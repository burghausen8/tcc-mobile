package br.com.cwi.rocar.data.database.mapper

import br.com.cwi.nespresso_app.data.database.entity.ClientEntity
import br.com.cwi.rocar.domain.entity.Client


fun Client.toEntity() = ClientEntity(
    id, name, cpf, street, nHome, city, phone
)