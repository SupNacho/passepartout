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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ProductWithCategoryEntity) return false

        if (category != other.category) return false
        if (product != other.product) return false
        if (prodCatId != other.prodCatId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = category.hashCode()
        result = 31 * result + product.hashCode()
        result = 31 * result + (prodCatId?.hashCode() ?: 0)
        return result
    }
}
