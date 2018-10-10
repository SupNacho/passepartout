package ru.supernacho.kt.passepartout.model.repository.dao

import androidx.room.*
import ru.supernacho.kt.passepartout.model.entity.ShopEntity

@Dao
interface ShopDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(shopEntity: ShopEntity): Long

    @Query("SELECT * FROM shopEntity")
    fun getShops(): List<ShopEntity>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(shopEntity: ShopEntity)

    @Delete
    fun delete(shopEntity: ShopEntity)
}