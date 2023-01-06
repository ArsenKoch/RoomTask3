package ua.cn.stu.room.model.accounts.room.entities

data class AccountSignInTuple(
    val id: Long,
    val password: String
)

// todo #7: Create a tuple for updating account username.
//          Such tuples should contain a primary key ('id') in order to notify Room which row you want to update
//          and fields to be updated ('username' is this case).
class AccountUpdateUsernameTuple(
    val id: Long,
    val username: String
)