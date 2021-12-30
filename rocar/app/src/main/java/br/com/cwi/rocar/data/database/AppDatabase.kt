package br.com.cwi.rocar.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.cwi.nespresso_app.data.database.dao.ClientDao
import br.com.cwi.nespresso_app.data.database.entity.ClientEntity

@Database(entities = [ClientEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getCoffeeDao(): ClientDao

    companion object {
        private const val DATABASE_NAME = "rocar-db"
        fun create(application: Application): AppDatabase {
            return Room.databaseBuilder(
                application,
                AppDatabase::class.java,
                DATABASE_NAME
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}