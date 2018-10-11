package ru.supernacho.kt.passepartout.model.entity


class ProductWithPrices(
        val productWithCategoryEntity: ProductWithCategoryEntity,

        val shopPricesEntity: List<ShopPricesEntity> = mutableListOf()
) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other !is ProductWithPrices) return false

                if (productWithCategoryEntity != other.productWithCategoryEntity) return false
                if (shopPricesEntity != other.shopPricesEntity) return false

                return true
        }

        override fun hashCode(): Int {
                var result = productWithCategoryEntity.hashCode()
                result = 31 * result + shopPricesEntity.hashCode()
                return result
        }
}