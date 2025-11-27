package com.example.appfrotas.ServiceApp.local.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.appfrotas.ServiceApp.Constants
import com.example.appfrotas.ServiceApp.local.DAO.ArrivalDAO
import com.example.appfrotas.ServiceApp.local.DAO.CarFrotaDAO
import com.example.appfrotas.ServiceApp.local.DAO.CarRequestDAO
import com.example.appfrotas.ServiceApp.local.DAO.ExitDAO
import com.example.appfrotas.ServiceApp.local.DAO.ObservationDAO
import com.example.appfrotas.ServiceApp.local.DAO.SupplyDAO
import com.example.appfrotas.ServiceApp.local.DAO.UserDAO
import com.example.appfrotas.ServiceApp.local.Converters
import com.example.appfrotas.ServiceApp.local.Entitys.ArrivalEntityLocal
import com.example.appfrotas.ServiceApp.local.Entitys.CarFrotaEntityLocal
import com.example.appfrotas.ServiceApp.local.Entitys.CarRequestEntityLocal
import com.example.appfrotas.ServiceApp.local.Entitys.ExitEntityLocal
import com.example.appfrotas.ServiceApp.local.Entitys.ObservationEntityLocal
import com.example.appfrotas.ServiceApp.local.Entitys.SupplyEntityLocal
import com.example.appfrotas.ServiceApp.local.Entitys.UserEntityLocal

@Database(
    entities = [
        UserEntityLocal::class,
        CarFrotaEntityLocal::class,
        ExitEntityLocal::class,
        ArrivalEntityLocal::class,
        SupplyEntityLocal::class,
        ObservationEntityLocal::class,
        CarRequestEntityLocal::class
    ], version = 1
)
@TypeConverters(Converters::class)
abstract class DataBaseFrotas : RoomDatabase() {

    abstract fun userDAO(): UserDAO
    abstract fun carDAO(): CarFrotaDAO
    abstract fun exitDAO(): ExitDAO
    abstract fun arrivalDAO(): ArrivalDAO
    abstract fun supplyDAO(): SupplyDAO
    abstract fun observationDAO(): ObservationDAO
    abstract fun carRequestDAO(): CarRequestDAO

    companion object {

        private lateinit var INSTANCE: DataBaseFrotas
        fun getDbFrotas(context: Context): DataBaseFrotas {
            if (!::INSTANCE.isInitialized) {
                synchronized(DataBaseFrotas::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context, DataBaseFrotas::class.java, Constants.Local.dataBase.nameDataBase
                    ).build()
                }
            }
            return INSTANCE
        }
    }

}