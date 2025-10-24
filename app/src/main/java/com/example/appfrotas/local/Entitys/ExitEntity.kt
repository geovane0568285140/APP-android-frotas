package com.example.appfrotas.local.Entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appfrotas.Constants
import java.util.UUID

@Entity(tableName = Constants.Local.dataBase.table.exitTable_name)
data class ExitEntity (
    @PrimaryKey()
    var id_exit_record: UUID = UUID.randomUUID()

)