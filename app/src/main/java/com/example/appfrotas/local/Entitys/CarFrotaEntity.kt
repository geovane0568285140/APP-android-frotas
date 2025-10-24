package com.example.appfrotas.local.Entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appfrotas.Constants
import java.util.UUID

@Entity(tableName = Constants.Local.dataBase.table.carFrotaTable_name)
data class CarFrotaEntity (
    @PrimaryKey()
    var id_frota: UUID = UUID.randomUUID()
)