package ua.cn.stu.room.model.boxes.room.views

import androidx.room.Embedded
import androidx.room.Relation
import ua.cn.stu.room.model.accounts.room.entities.AccountDbEntity
import ua.cn.stu.room.model.boxes.room.entities.BoxDbEntity

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