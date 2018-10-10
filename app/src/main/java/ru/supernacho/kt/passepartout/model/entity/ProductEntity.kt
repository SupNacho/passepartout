package ru.supernacho.kt.passepartout.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ProductEntity(
        val productName: String,
        @PrimaryKey(autoGenerate = true)
        val productId: Long? = null
)