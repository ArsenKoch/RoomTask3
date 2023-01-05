package ua.cn.stu.room.model.accounts.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import ua.cn.stu.room.model.accounts.entities.Account
import ua.cn.stu.room.model.accounts.entities.SignUpData

@Entity(
    tableName = "accounts",
    indices = [
        Index("email", unique = true)
    ]
)

data class AccountDbEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "email", collate = ColumnInfo.NOCASE) val email: String,
    val username: String,
    val password: String,
    @ColumnInfo(name = "createdAt") val createdAt: Long,
) {

    fun toAccount(): Account = Account(
        id, username, email, createdAt
    )

    companion object {
        fun fromSignUpData(signUpData: SignUpData): AccountDbEntity = AccountDbEntity(
            id = 0,
            email = signUpData.email,
            username = signUpData.username,
            password = signUpData.password,
            createdAt = System.currentTimeMillis()
        )
    }
}
