package ru.supernacho.kt.passepartout.presenter

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Scheduler
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ru.supernacho.kt.passepartout.model.entity.CategoryEntity
import ru.supernacho.kt.passepartout.model.entity.ProductWithCategoryEntity
import ru.supernacho.kt.passepartout.model.repository.DbRepository
import ru.supernacho.kt.passepartout.view.ProductView
import javax.inject.Inject

@InjectViewState
class ProductPresenter(val uiSchduler: Scheduler) : MvpPresenter<ProductView>() {
    @Inject
    lateinit var dbRepository: DbRepository
    var categories = listOf<CategoryEntity>()
    var products = listOf<ProductWithCategoryEntity>()

    fun checkDb(){
        Log.d("DB", " Test DB here")
        dbRepository.addCategory(CategoryEntity("Bread"))
    }

    fun getCategories() = dbRepository.getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(uiSchduler)
            .subscribe(object: SingleObserver<List<CategoryEntity>>{
                override fun onSuccess(t: List<CategoryEntity>) {
                    categories = t
                    viewState.updateCategories(t)
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {

                }

            })

    fun getProductsByCategory(categoryEntity: CategoryEntity?){
        dbRepository.getProductsWithCategories(categoryEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(uiSchduler)
                .subscribe(object : SingleObserver<List<ProductWithCategoryEntity>>{
                    override fun onSuccess(t: List<ProductWithCategoryEntity>) {
                        products = t
                        viewState.updateProducts(t)
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {

                    }
                })
    }
}