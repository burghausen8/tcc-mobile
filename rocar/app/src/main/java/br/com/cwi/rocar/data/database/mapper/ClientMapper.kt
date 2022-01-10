package br.com.cwi.rocar.data.database.mapper

import br.com.cwi.nespresso_app.data.database.entity.ClientEntity
import br.com.cwi.rocar.domain.entity.Client

fun ClientEntity.toClient() = Client (
    id, name, cpf, street, nHome, city, phone
)

fun Client.toEntity() = ClientEntity (
  id,name,cpf,street,nHome,city,phone
)