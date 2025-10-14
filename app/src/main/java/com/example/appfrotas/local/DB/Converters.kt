package com.example.appfrotas.local.DB

import androidx.room.TypeConverter
import com.example.appfrotas.Constants
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Converters {

    private val formatter = DateTimeFormatter.ofPattern(Constants.DateTime.dateTime)

    @TypeConverter
    fun dataTime_String(date: LocalDateTime): String {
        return date.format(formatter)
    }

    @TypeConverter
    fun string_Datatime(dateTimeString: String): LocalDateTime{
        return LocalDateTime.parse(dateTimeString, formatter)
    }

}