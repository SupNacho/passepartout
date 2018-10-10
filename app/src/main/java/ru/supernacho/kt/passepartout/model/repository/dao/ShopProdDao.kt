package ru.supernacho.kt.passepartout.model.repository.dao

import androidx.room.*
import ru.supernacho.kt.passepartout.model.entity.ShopPricesEntity

@Dao
interface ShopProdDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(shopPrices: ShopPricesEntity): Long

    @Query("SELECT * FROM ShopPricesEntity")
    fun getShopsAndProds(): List<ShopPricesEntity>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(shopPrices: ShopPricesEntity)

    @Delete
    fun delete(shopPrices: ShopPricesEntity)
}