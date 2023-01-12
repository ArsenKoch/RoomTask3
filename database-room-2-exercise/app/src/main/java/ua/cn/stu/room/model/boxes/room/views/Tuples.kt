package ua.cn.stu.room.model.boxes.room.views

import androidx.room.Embedded
import androidx.room.Relation
import ua.cn.stu.room.model.accounts.room.entities.AccountDbEntity
import ua.cn.stu.room.model.boxes.room.entities.BoxDbEntity

// todo #14: Create a SettingWithEntitiesTuple class which should mirror the same data
//           as SettingsDbView but use @Relation annotation instead of identifiers to fetch
//           AccountDbEntity and BoxDbEntity instead of 'account_id' and 'box_id' columns.

data class SettingWithEntitiesTuple(
    @Embedded val settingsDbView: SettingsDbView,

    @Relation(
        parentColumn = "account_id",
        entityColumn = "id"
    )
    val accountDbEntity: AccountDbEntity,


    @Relation(
        parentColumn = "box_id",
        entityColumn = "id"
    )
    val boxDbEntity: BoxDbEntity
)