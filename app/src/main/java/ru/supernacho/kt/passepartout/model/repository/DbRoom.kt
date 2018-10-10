package ru.supernacho.kt.passepartout.model.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.supernacho.kt.passepartout.model.entity.*
import ru.supernacho.kt.passepartout.model.repository.dao.*

@Database(entities = [CategoryEntity::class, ProductEntity::class, ProductWithCategoryEntity::class,
ShopEntity::class, ShopPricesEntity::class], version = 1, exportSchema = false)
abstract class DbRoom: RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun catProducts(): CatProdDao
    abstract fun productDao(): ProductDao
    abstract fun shopDao(): ShopDao
    abstract fun shopProductsDao(): ShopProdDao
}