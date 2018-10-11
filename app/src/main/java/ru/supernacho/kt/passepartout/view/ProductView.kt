package ru.supernacho.kt.passepartout.view

import androidx.lifecycle.LiveData
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.supernacho.kt.passepartout.model.entity.CategoryEntity
import ru.supernacho.kt.passepartout.model.entity.ProductWithCategoryEntity
import ru.supernacho.kt.passepartout.model.entity.ProductWithPrices

@StateStrategyType(SingleStateStrategy::class)
interface ProductView: MvpView {
    fun updateCategories(categories: List<CategoryEntity>)
    fun updateProducts(products: List<ProductWithPrices>)
//    fun updateProducts(products: List<ProductWithCategoryEntity>)
}