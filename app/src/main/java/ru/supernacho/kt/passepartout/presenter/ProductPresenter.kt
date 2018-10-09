package ru.supernacho.kt.passepartout.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Scheduler
import ru.supernacho.kt.passepartout.view.ProductView

@InjectViewState
class ProductPresenter(val uiSchduler: Scheduler): MvpPresenter<ProductView>() {

}