package ru.supernacho.kt.passepartout.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Scheduler
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import ru.supernacho.kt.passepartout.model.entity.CategoryEntity
import ru.supernacho.kt.passepartout.model.repository.DbRepository
import ru.supernacho.kt.passepartout.view.dialogs.IAddCtaegoryDialog
import javax.inject.Inject

@InjectViewState
class AddCatDialogPresenter(private val uiScheduler: Scheduler) : MvpPresenter<IAddCtaegoryDialog>() {
    @Inject
    lateinit var dbRepository: DbRepository

    fun addCategory(categoryName: String) {
        GlobalScope.launch(Dispatchers.Main) {
            val job = dbRepository.addCategory(CategoryEntity(categoryName))
            if (job.await() > -1)
                viewState.onSuccess()
            else
                viewState.onError()
        }
    }
}