package com.example.appfrotas.local.Entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appfrotas.view.service.Constants
import java.util.UUID

@Entity(tableName = Constants.Local.dataBase.table.arrivalTable_name)
data class ArrivalEntityLocal (
    @PrimaryKey()
    var id_arrival_record: UUID = UUID.randomUUID()
)