package ua.cn.stu.room.model.accounts.room.entities

import androidx.room.ColumnInfo
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation
import ua.cn.stu.room.model.boxes.room.entities.AccountBoxSettingDbEntity
import ua.cn.stu.room.model.boxes.room.entities.BoxDbEntity

data class AccountSignInTuple(
    @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "password") val password: String
)

data class AccountUpdateUsernameTuple(
    @ColumnInfo(name = "id") @PrimaryKey val id: Long,
    @ColumnInfo(name = "username") val username: String
)

data class AccountAndEditedBoxesTuple(
    val accountDbEntity: AccountDbEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = AccountBoxSettingDbEntity::class,
            parentColumn = "account_id",
            entityColumn = "box_id"
        )
    )
    val boxDbEntity: List<BoxDbEntity>
)

// todo #19: Create an AccountAndAllSettingsTuple + SettingAndBoxTuple classes (hint: both of them with
//           @Relation annotation). AccountAndAllSettingsTuple should fetch account data from 'accounts'
//           table and also should contain a reference to the SettingAndBoxTuple. The latter should
//           contain data from 'SettingDbView' ('is_active' flag) and also it should contain a reference
//           to the BoxDbEntity (data from 'boxes' table).