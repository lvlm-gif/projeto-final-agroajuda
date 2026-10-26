package com.example.agroajuda.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.agroajuda.data.local.dao.ClienteDao
import com.example.agroajuda.data.local.dao.ProfissionalDao
import com.example.agroajuda.model.Cliente
import com.example.agroajuda.model.Profissional

@Database(entities = [Profissional::class, Cliente::class], version = 3, exportSchema = false)
abstract class AgroAjudaDatabase : RoomDatabase() {

    abstract fun profissionalDao(): ProfissionalDao
    abstract fun clienteDao(): ClienteDao

    companion object {
        @Volatile
        private var INSTANCE: AgroAjudaDatabase? = null

        private val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    "CREATE TABLE IF NOT EXISTS `clientes` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT NOT NULL, `telefone` TEXT NOT NULL, `email` TEXT NOT NULL, `localizacao` TEXT NOT NULL)"
                )
            }
        }

        fun getDatabase(context: Context): AgroAjudaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AgroAjudaDatabase::class.java,
                    "agroajuda_database"
                )
                .addMigrations(MIGRATION_2_3)
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
