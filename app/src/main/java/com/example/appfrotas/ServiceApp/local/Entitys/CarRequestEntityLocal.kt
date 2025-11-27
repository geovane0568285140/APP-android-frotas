package com.example.appfrotas.ServiceApp.local.Entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appfrotas.ServiceApp.Constants
import java.util.UUID

@Entity(tableName = Constants.Local.dataBase.table.carRequestTable_name)
data class CarRequestEntityLocal (
    @PrimaryKey()
    var id_car_request: UUID = UUID.randomUUID()
)