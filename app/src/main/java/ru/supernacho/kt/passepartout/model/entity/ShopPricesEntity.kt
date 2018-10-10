package ru.supernacho.kt.passepartout.model.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ShopPricesEntity(
        @Embedded
        val shop: ShopEntity,
        @Embedded
        val product: ProductEntity,
        val price: Double,
        @PrimaryKey(autoGenerate = true)
        val shopPricesId: Long? = null
)