package com.tenxgames.surway.modules.auth.ui.model

import com.tenxgames.surway.modules.auth.data.model.UserEntity

data class User(
    val id: Long,
    val fullName: String,
    val email: String
)

fun UserEntity.toPresentation() =
    User(
        id = this.id,
        fullName = this.fullName,
        email = this.email
    )