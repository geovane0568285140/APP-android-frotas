package com.example.appfrotas.local.Entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appfrotas.Constants
import java.util.UUID

@Entity(tableName = Constants.Local.dataBase.table.carRequestTable_name)
data class CarRequestEntity (
    @PrimaryKey()
    var id_car_request: UUID = UUID.randomUUID()
)