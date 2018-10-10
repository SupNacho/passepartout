package ru.supernacho.kt.passepartout.model.repository.dao

import androidx.room.*
import ru.supernacho.kt.passepartout.model.entity.CategoryEntity

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(categoryEntity: CategoryEntity): Long

    @Query("SELECT * FROM categoryEntity")
    fun getCategories(): List<CategoryEntity>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(categoryEntity: CategoryEntity)

    @Delete
    fun delete(categoryEntity: CategoryEntity)
}