package ua.cn.stu.room.model.boxes.room.views

import androidx.room.ColumnInfo
import androidx.room.DatabaseView
import androidx.room.Embedded
import ua.cn.stu.room.model.boxes.room.entities.SettingsTuple

// todo #8: Create a database view named SettingsDbView with columns 'account_id', 'box_id', 'color_name', 'color_value'
//          and 'is_active' ('color_name' and 'color_value' from 'boxes' table, other columns
//          from 'accounts_boxes_settings' table). The view should contain rows which are absent
//          in 'accounts_boxes_settings' table filled with default 'is_active' value (is_active = 1)
//          Hints:
//            1) use JOIN and LEFT JOIN
//            2) use ifnull() SQLite-function for assigning default value
//            3) use @DatabaseView annotation to create a view
//            4) use 'DB Browser for SQLite' app to test SQL-queries.

@DatabaseView(
    viewName = "settings_view",
    value = "SELECT accounts.id as account_id,\n" +
            "       boxes.id as box_id,\n" +
            "       boxes.color_name,\n" +
            "       boxes.color_value,\n" +
            "       ifnull(accounts_boxes_settings.is_active, 1) as is_active\n" +
            "       FROM accounts\n" +
            "       JOIN boxes\n" +
            "       LEFT JOIN accounts_boxes_settings\n" +
            "       ON accounts_boxes_settings.account_id = accounts.id\n" +
            "       AND accounts_boxes_settings.box_id = boxes.id"
)
data class SettingsDbView(
@ColumnInfo(name = "account_id") val accountId: Long,
@ColumnInfo(name = "box_id") val boxId: Long,
@ColumnInfo(name = "color_name") val colorName: String,
@ColumnInfo(name = "color_value") val colorValue: String,
@Embedded val settingsTuple: SettingsTuple
)

// todo #13: Remove 'color_name' and 'color_value' columns from the database view. Make the structure
//           of the view the same as in 'accounts_boxes_settings' table. The only difference: view
//           should also contain rows which are absent in 'accounts_boxes_settings' table filled
//           with default 'is_active' value (is_active = 1)