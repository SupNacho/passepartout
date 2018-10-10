package ru.supernacho.kt.passepartout.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CategoryEntity(
        val categoryName: String,
        @PrimaryKey(autoGenerate = true)
        val idCategory: Long? = null
)