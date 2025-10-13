package com.example.appfrotas.local.DB

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appfrotas.local.DAO.UserDAO

abstract class DataBaseFrotas: RoomDatabase() {

    abstract fun userDAO(): UserDAO

    companion object {

        private lateinit var INSTANCE: DataBaseFrotas

        fun getDbFrotas(context: Context): DataBaseFrotas{
            if (!::INSTANCE.isInitialized){
                synchronized(DataBaseFrotas::class.java){
                    INSTANCE = Room.databaseBuilder(context, DataBaseFrotas::class.java, "db.frotas")
                        .build()
                }
            }
            return INSTANCE
        }
    }
}