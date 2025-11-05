package com.example.appfrotas.local.Entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appfrotas.view.service.Constants
import java.util.UUID

@Entity(tableName = Constants.Local.dataBase.table.supplyTable_name)
data class SupplyEntity (
    @PrimaryKey()
    var id_supply: UUID = UUID.randomUUID()
)