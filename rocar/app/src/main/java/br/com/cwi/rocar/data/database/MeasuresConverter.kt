package br.com.cwi.rocar.data.database

import androidx.room.TypeConverter

class MeasuresConverter {
    @TypeConverter
    fun fromStringList(value: List<String>) = value.joinToString { it }

    @TypeConverter
    fun fromString(value: String) = value.split(",")
}