package ua.cn.stu.room.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ua.cn.stu.room.model.accounts.room.entities.AccountDbEntity

@Database(
    version = 1,
    entities = [
        AccountDbEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    // todo #10: Add abstract getAccountsDao() method
    abstract fun getAccountsDao()

    // todo #18: Add abstract getBoxesDao() method
    abstract fun getBoxesDao()
}