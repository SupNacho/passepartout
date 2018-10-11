package ru.supernacho.kt.passepartout.model.repository

import android.util.Log
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.experimental.*
import ru.supernacho.kt.passepartout.model.entity.*

class DbRepository(
        private var dbRoom: DbRoom) {

    fun addCategory(categoryEntity: CategoryEntity) = GlobalScope.launch(Dispatchers.IO) {
        val id = dbRoom.categoryDao().insert(categoryEntity)
        Log.d("DB", "added  category id: $id name: ${categoryEntity.categoryName}")
    }

    fun addProduct(productEntity: ProductEntity) = GlobalScope.launch(Dispatchers.IO) {
        val id = dbRoom.productDao().insert(productEntity)
        Log.d("DB", "added  product id: $id name: ${productEntity.productName}")
    }

    fun addShop(shopEntity: ShopEntity) = GlobalScope.launch(Dispatchers.IO) {
        val id = dbRoom.shopDao().insert(shopEntity)
        Log.d("DB", "added  shop id: $id name: ${shopEntity.shopName}")
    }

    fun getCategories(): Single<List<CategoryEntity>> = Single.create<List<CategoryEntity>> {
        val list = dbRoom.categoryDao().getCategories()
        it.onSuccess(list)
    }

    fun getProductsWithCategories(categoryEntity: CategoryEntity?): Single<List<ProductWithPrices>> = Single.create<List<ProductWithPrices>> {
        if (categoryEntity?.idCategory != null) {
            val list = dbRoom.catProducts().getCatsAndProdsById(categoryEntity.idCategory)
            val shops = dbRoom.shopProductsDao().getShopsAndProds()
            val finalList = mutableListOf<ProductWithPrices>()
            list.forEach {
                val entry = ProductWithPrices(it)
                shops.forEach {
                    if (entry.productWithCategoryEntity.product.productId == it.product.productId)
                        (entry.shopPricesEntity as ArrayList).add(it)
                }
                finalList.add(entry)
            }
            it.onSuccess(finalList as List<ProductWithPrices>)
        } else {
            val finalList = mutableListOf<ProductWithPrices>()
            val list = dbRoom.catProducts().getCatsAndProds()
            val shops = dbRoom.shopProductsDao().getShopsAndProds()
            list.forEach {
                val entry = ProductWithPrices(it)
                shops.forEach {
                    if (entry.productWithCategoryEntity.product.productId == it.product.productId)
                        (entry.shopPricesEntity as ArrayList).add(it)
                }
                finalList.add(entry)
            }
            it.onSuccess(finalList)
        }
    }
}