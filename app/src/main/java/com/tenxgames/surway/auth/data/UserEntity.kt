package com.tenxgames.surway.auth.data

import com.google.gson.annotations.SerializedName
import com.tenxgames.surway.auth.User


data class UserEntity(
    @SerializedName("id")
    val id: Long,

    @SerializedName("full_name")
    val fullName: String,

    @SerializedName("email")
    val email: String
) {
    fun toPresentation() = User(id, fullName, email)
}

fun User.toEntity() = UserEntity(this.id, this.fullName, this.email)