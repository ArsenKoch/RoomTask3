package ua.cn.stu.tabs.model.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AppSQLiteHelper(
    private val applicationContext: Context
) : SQLiteOpenHelper(applicationContext, "database.db", null, 1) {

    override fun onCreate(p0: SQLiteDatabase) {
        val sql = applicationContext.assets.open("db_init.sql").bufferedReader().use {
            it.readText()
        }
        sql.split(';')
            .filter { it.isNotBlank() }
            .forEach {
                p0.execSQL(it)
            }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {}
}