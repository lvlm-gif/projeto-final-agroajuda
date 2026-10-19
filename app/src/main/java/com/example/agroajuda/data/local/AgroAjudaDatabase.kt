package com.example.agroajuda.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.agroajuda.data.local.dao.ProfissionalDao
import com.example.agroajuda.model.Profissional

@Database(entities = [Profissional::class], version = 2, exportSchema = false)
abstract class AgroAjudaDatabase : RoomDatabase() {

    abstract fun profissionalDao(): ProfissionalDao

    companion object {
        @Volatile
        private var INSTANCE: AgroAjudaDatabase? = null

        fun getDatabase(context: Context): AgroAjudaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AgroAjudaDatabase::class.java,
                    "agroajuda_database"
                )
                .fallbackToDestructiveMigration() // Adicionado para lidar com a mudança de esquema (versão 1 -> 2)
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
