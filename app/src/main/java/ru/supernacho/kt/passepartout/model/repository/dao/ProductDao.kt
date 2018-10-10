package ru.supernacho.kt.passepartout.model.repository.dao

import androidx.room.*
import ru.supernacho.kt.passepartout.model.entity.ProductEntity

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(productEntity: ProductEntity): Long

    @Query("SELECT * FROM productEntity")
    fun getProducts(): List<ProductEntity>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(productEntity: ProductEntity)

    @Delete
    fun delete(productEntity: ProductEntity)
}