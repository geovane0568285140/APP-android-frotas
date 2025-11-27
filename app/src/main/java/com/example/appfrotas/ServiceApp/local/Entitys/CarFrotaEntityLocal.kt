package com.example.appfrotas.ServiceApp.local.Entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appfrotas.ServiceApp.Constants
import java.util.UUID

@Entity(tableName = Constants.Local.dataBase.table.carFrotaTable_name)
data class CarFrotaEntityLocal (
    @PrimaryKey()
    var id_frota: UUID = UUID.randomUUID()
)