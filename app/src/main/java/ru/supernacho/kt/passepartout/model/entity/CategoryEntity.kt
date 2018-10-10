package ru.supernacho.kt.passepartout.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CategoryEntity(
        val categoryName: String,
        @PrimaryKey(autoGenerate = true)
        val idCategory: Long? = null


) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other !is CategoryEntity) return false

                if (categoryName != other.categoryName) return false
                if (idCategory != other.idCategory) return false

                return true
        }

        override fun hashCode(): Int {
                var result = categoryName.hashCode()
                result = 31 * result + (idCategory?.hashCode() ?: 0)
                return result
        }
}