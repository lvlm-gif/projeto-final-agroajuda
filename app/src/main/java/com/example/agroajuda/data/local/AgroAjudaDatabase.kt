package com.example.agroajuda.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.agroajuda.data.local.dao.ClienteDao
import com.example.agroajuda.data.local.dao.ProfissionalDao
import com.example.agroajuda.data.local.dao.SolicitacaoDao
import com.example.agroajuda.model.Cliente
import com.example.agroajuda.model.Profissional
import com.example.agroajuda.model.Solicitacao

@Database(entities = [Profissional::class, Cliente::class, Solicitacao::class], version = 5, exportSchema = false)
abstract class AgroAjudaDatabase : RoomDatabase() {

    abstract fun profissionalDao(): ProfissionalDao
    abstract fun clienteDao(): ClienteDao
    abstract fun solicitacaoDao(): SolicitacaoDao

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

        private val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    "CREATE TABLE IF NOT EXISTS `solicitacoes` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `profissionalId` INTEGER NOT NULL, `status` TEXT NOT NULL, `data` TEXT NOT NULL)"
                )
            }
        }

        private val MIGRATION_4_5 = object : Migration(4, 5) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    "ALTER TABLE `solicitacoes` ADD COLUMN `clienteId` INTEGER NOT NULL DEFAULT 0"
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
                .addMigrations(MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5)
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
