package com.example.appfrotas.local.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.appfrotas.view.service.Constants
import com.example.appfrotas.local.DAO.ArrivalDAO
import com.example.appfrotas.local.DAO.CarFrotaDAO
import com.example.appfrotas.local.DAO.CarRequestDAO
import com.example.appfrotas.local.DAO.ExitDAO
import com.example.appfrotas.local.DAO.ObservationDAO
import com.example.appfrotas.local.DAO.SupplyDAO
import com.example.appfrotas.local.DAO.UserDAO
import com.example.appfrotas.local.Entitys.ArrivalEntity
import com.example.appfrotas.local.Entitys.CarFrotaEntity
import com.example.appfrotas.local.Entitys.CarRequestEntity
import com.example.appfrotas.local.Entitys.ExitEntity
import com.example.appfrotas.local.Entitys.ObservationEntity
import com.example.appfrotas.local.Entitys.SupplyEntity
import com.example.appfrotas.local.Entitys.UserEntity

@Database(
    entities = [
        UserEntity::class,
        CarFrotaEntity::class,
        ExitEntity::class,
        ArrivalEntity::class,
        SupplyEntity::class,
        ObservationEntity::class,
        CarRequestEntity::class
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