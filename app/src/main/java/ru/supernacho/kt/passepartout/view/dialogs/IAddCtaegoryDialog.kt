package ru.supernacho.kt.passepartout.view.dialogs

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface IAddCtaegoryDialog: MvpView {
    fun onSuccess()
    fun onError()
}