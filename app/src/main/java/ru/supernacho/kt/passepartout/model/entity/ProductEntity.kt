package ru.supernacho.kt.passepartout.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ProductEntity(
        val productName: String,
        @PrimaryKey(autoGenerate = true)
        val productId: Long? = null
) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other !is ProductEntity) return false

                if (productName != other.productName) return false
                if (productId != other.productId) return false

                return true
        }

        override fun hashCode(): Int {
                var result = productName.hashCode()
                result = 31 * result + (productId?.hashCode() ?: 0)
                return result
        }
}