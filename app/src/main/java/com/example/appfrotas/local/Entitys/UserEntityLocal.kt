package com.example.appfrotas.local.Entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appfrotas.view.service.Constants
import java.util.UUID

@Entity(tableName = Constants.Local.dataBase.table.userTable_name)
data class UserEntityLocal (
    @PrimaryKey()
    var id_user: UUID = UUID.randomUUID()
)

