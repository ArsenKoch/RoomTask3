package ua.cn.stu.room.model.boxes.room.entities

import androidx.room.ColumnInfo

data class SettingsTuple(
    @ColumnInfo(name = "is_active") val isActive: Boolean
)


// todo #5: Create a BoxAndSettingsTuple class which joins two entities: BoxDbEntity and
//          AccountBoxSettingDbEntity. Please note that AccountBoxSettingDbEntity is optional.
