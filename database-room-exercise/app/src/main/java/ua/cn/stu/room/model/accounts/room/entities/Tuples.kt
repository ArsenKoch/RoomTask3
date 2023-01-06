package ua.cn.stu.room.model.accounts.room.entities

data class AccountSignInTuple(
    val id: Long,
    val password: String
)

class AccountUpdateUsernameTuple(
    val id: Long,
    val username: String
)