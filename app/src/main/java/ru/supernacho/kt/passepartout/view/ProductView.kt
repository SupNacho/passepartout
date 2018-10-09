package ru.supernacho.kt.passepartout.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface ProductView: MvpView {
    fun updateCategories()
    fun updateProducts()
}