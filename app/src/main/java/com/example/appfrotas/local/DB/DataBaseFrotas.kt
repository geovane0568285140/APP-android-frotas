package com.example.appfrotas.local.DB

import androidx.room.RoomDatabase
import com.example.appfrotas.local.DAO.UserDAO

abstract class DataBase: RoomDatabase() {

    abstract fun userDAO(): UserDAO

    companion object {

        private lateinit var INSTANCE:

    }
}