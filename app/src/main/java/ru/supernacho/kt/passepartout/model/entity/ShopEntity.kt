package ru.supernacho.kt.passepartout.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ShopEntity(
        val shopName: String,
        @PrimaryKey(autoGenerate = true)
        val shopId: Long? = null
)