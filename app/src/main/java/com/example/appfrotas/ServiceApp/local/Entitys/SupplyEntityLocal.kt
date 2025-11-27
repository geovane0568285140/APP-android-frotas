package com.example.appfrotas.ServiceApp.local.Entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appfrotas.ServiceApp.Constants
import java.util.UUID

@Entity(tableName = Constants.Local.dataBase.table.supplyTable_name)
data class SupplyEntityLocal (
    @PrimaryKey()
    var id_supply: UUID = UUID.randomUUID()
)