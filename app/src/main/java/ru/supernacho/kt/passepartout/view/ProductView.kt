package ru.supernacho.kt.passepartout.view

import androidx.lifecycle.LiveData
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.supernacho.kt.passepartout.model.entity.CategoryEntity
import ru.supernacho.kt.passepartout.model.entity.ProductWithCategoryEntity

@StateStrategyType(SingleStateStrategy::class)
interface ProductView: MvpView {
    fun updateCategories(categories: List<CategoryEntity>)
    fun updateProducts(products: List<ProductWithCategoryEntity>)
}