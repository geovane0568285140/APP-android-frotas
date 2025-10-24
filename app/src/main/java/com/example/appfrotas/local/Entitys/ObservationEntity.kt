package com.example.appfrotas.local.Entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appfrotas.Constants
import java.util.UUID

@Entity(tableName = Constants.Local.dataBase.table.observationTable_name)
data class ObservationEntity (
    @PrimaryKey()
    var id_observation: UUID = UUID.randomUUID()
)