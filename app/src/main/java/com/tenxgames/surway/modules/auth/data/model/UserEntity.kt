package com.tenxgames.surway.modules.auth.data.model

import com.google.gson.annotations.SerializedName
import com.tenxgames.surway.modules.auth.ui.model.User


data class UserEntity(
    @SerializedName("id")
    val id: Long,

    @SerializedName("full_name")
    val fullName: String,

    @SerializedName("email")
    val email: String
)

fun User.toEntity() =
    UserEntity(
        id = this.id,
        fullName = this.fullName,
        email = this.email
    )