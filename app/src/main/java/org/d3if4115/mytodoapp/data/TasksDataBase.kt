package org.d3if4115.mytodoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import org.d3if4115.mytodoapp.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    class Callback @Inject constructor(
        private val database: Provider<TaskDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().taskDao()

            applicationScope.launch {
                dao.insert(Task("Ngerjain Modul"))
                dao.insert(Task("Beli Makan"))
                dao.insert(Task("Ke Lab", important = true))
                dao.insert(Task("Ngerjain Assesment", completed = true))
                dao.insert(Task("Olahraga"))
                dao.insert(Task("Ke Kontrakan", completed = true))
            }
        }
    }
}