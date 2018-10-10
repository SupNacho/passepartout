package ru.supernacho.kt.passepartout.presenter

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Scheduler
import ru.supernacho.kt.passepartout.model.entity.CategoryEntity
import ru.supernacho.kt.passepartout.model.repository.DbRepository
import ru.supernacho.kt.passepartout.view.ProductView
import javax.inject.Inject

@InjectViewState
class ProductPresenter(val uiSchduler: Scheduler) : MvpPresenter<ProductView>() {
    @Inject
    lateinit var dbRepository: DbRepository

    fun checkDb(){
        Log.d("DB", " Test DB here")
        dbRepository.addCategory(CategoryEntity("Bread"))
    }
}