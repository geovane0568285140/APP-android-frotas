package com.example.appfrotas.ServiceApp.local.Entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appfrotas.ServiceApp.Constants
import java.util.UUID

@Entity(tableName = Constants.Local.dataBase.table.exitTable_name)
data class ExitEntityLocal (
    @PrimaryKey()
    var id_exit_record: UUID = UUID.randomUUID()

)