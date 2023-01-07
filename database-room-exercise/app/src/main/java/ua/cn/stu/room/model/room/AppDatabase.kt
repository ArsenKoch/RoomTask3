package ua.cn.stu.room.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ua.cn.stu.room.model.accounts.room.AccountsDao
import ua.cn.stu.room.model.accounts.room.entities.AccountDbEntity

@Database(
    version = 1,
    entities = [
        AccountDbEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAccountsDao(): AccountsDao

    // todo #18: Add abstract getBoxesDao() method
}