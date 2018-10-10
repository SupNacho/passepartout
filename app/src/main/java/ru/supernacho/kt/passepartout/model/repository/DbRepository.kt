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

    fun getProductsWithCategories(categoryEntity: CategoryEntity?): Single<List<ProductWithCategoryEntity>>
            = Single.create<List<ProductWithCategoryEntity>> {
        if (categoryEntity?.idCategory != null) {
            val list = dbRoom.catProducts().getCatsAndProdsById(categoryEntity.idCategory)
            it.onSuccess(list)
        } else {
            val list = dbRoom.catProducts().getCatsAndProds()
            it.onSuccess(list)
        }
    }
}