package ru.supernacho.kt.passepartout.model.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ProductWithCategoryEntity(
        @Embedded
        val category: CategoryEntity,
        @Embedded
        val product: ProductEntity,
        @PrimaryKey(autoGenerate = true)
        val prodCatId: Long? = null
)