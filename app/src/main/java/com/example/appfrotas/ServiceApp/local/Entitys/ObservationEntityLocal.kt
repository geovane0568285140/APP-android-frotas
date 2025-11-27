package com.example.appfrotas.ServiceApp.local.Entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appfrotas.ServiceApp.Constants
import java.util.UUID

@Entity(tableName = Constants.Local.dataBase.table.observationTable_name)
data class ObservationEntityLocal (
    @PrimaryKey()
    var id_observation: UUID = UUID.randomUUID()
)