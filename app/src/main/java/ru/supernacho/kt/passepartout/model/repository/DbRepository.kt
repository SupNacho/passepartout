package ru.supernacho.kt.passepartout.model.repository

import android.util.Log
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import ru.supernacho.kt.passepartout.model.entity.CategoryEntity
import ru.supernacho.kt.passepartout.model.entity.ProductEntity
import ru.supernacho.kt.passepartout.model.entity.ShopEntity

class DbRepository(
        private var dbRoom: DbRoom) {

    fun addCategory(categoryEntity: CategoryEntity)= launch {
        val id = dbRoom.categoryDao().insert(categoryEntity)
        Log.d("DB", "added  category id: $id name: ${categoryEntity.categoryName}")
    }

    fun addProduct(productEntity: ProductEntity)= launch {
        val id = dbRoom.productDao().insert(productEntity)
        Log.d("DB", "added  product id: $id name: ${productEntity.productName}")
    }

    fun addShop(shopEntity: ShopEntity) = launch {
        val id = dbRoom.shopDao().insert(shopEntity)
        Log.d("DB", "added  shop id: $id name: ${shopEntity.shopName}")
    }
}