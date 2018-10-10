package ru.supernacho.kt.passepartout.model.repository.dao

import androidx.room.*
import ru.supernacho.kt.passepartout.model.entity.ProductWithCategoryEntity

@Dao
interface CatProdDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(productWithCategoryEntity: ProductWithCategoryEntity): Long

    @Query("SELECT * FROM productWithCategoryEntity")
    fun getCatsAndProds(): List<ProductWithCategoryEntity>

    @Query("SELECT * FROM productWithCategoryEntity WHERE idCategory = :catId")
    fun getCatsAndProdsById(catId: Long): List<ProductWithCategoryEntity>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(productWithCategoryEntity: ProductWithCategoryEntity)

    @Delete
    fun delete(productWithCategoryEntity: ProductWithCategoryEntity)
}