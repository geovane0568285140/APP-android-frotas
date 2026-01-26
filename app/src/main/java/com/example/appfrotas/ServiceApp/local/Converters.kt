package com.example.appfrotas.ServiceApp.local

import androidx.room.TypeConverter
import com.example.appfrotas.ServiceApp.Constants
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class Converters {

    private val formatter = DateTimeFormatter.ofPattern(Constants.DateFormatter.dateTime)

    @TypeConverter
    fun dataTime_String(date: LocalDateTime): String {
        return date.format(formatter)
    }

    @TypeConverter
    fun string_Datatime(dateTimeString: String): LocalDateTime {
        return LocalDateTime.parse(dateTimeString, formatter)
    }

    companion object{
        fun formaterDDMM(dataTimeString: String): String {

            val dia = dataTimeString.substring(8, 10)
            val mes = dataTimeString.substring(5, 7)

            return "$dia/$mes"
        }


        fun Milllis_Date(millis: Long): String {
            val date = Instant.ofEpochMilli(millis)
                .atZone(ZoneId.systemDefault())
                .toLocalDate()

            val formatter = DateTimeFormatter.ofPattern(Constants.DateFormatter.date)
            return date.format(formatter)
        }

        fun formatterToApi(date: String): String {
            val inputFormatter = DateTimeFormatter.ofPattern(Constants.DateFormatter.date)
            val outPutFormatter = DateTimeFormatter.ofPattern(Constants.DateFormatter.localDate)

            return LocalDate.parse(date, inputFormatter).format(outPutFormatter)
        }

        fun localDateTime_LocalDate(localDateTime: String): String{
            val outPutFormatter = DateTimeFormatter.ofPattern(Constants.DateFormatter.date)

            return LocalDate.parse(localDateTime.substring(0, 10)).format(outPutFormatter)
        }


    }

}