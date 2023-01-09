package ua.cn.stu.room.model.boxes.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ua.cn.stu.room.model.boxes.room.entities.AccountBoxSettingDbEntity
import ua.cn.stu.room.model.boxes.room.entities.BoxDbEntity

@Dao
interface BoxesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setActiveFlagForBox(accountBoxSettingDbEntity: AccountBoxSettingDbEntity)

    @Query("SELECT * FROM boxes LEFT JOIN account_box_settings ON boxes.id = account_box_settings.account_id = :accountId")
    fun getBoxesAndSettings(accountId: Long): kotlinx.coroutines.flow.Flow<Map<BoxDbEntity, AccountBoxSettingDbEntity?>>
}