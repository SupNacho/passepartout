package ru.supernacho.kt.passepartout.di

import dagger.Component
import ru.supernacho.kt.passepartout.App
import ru.supernacho.kt.passepartout.di.modules.AppModule
import ru.supernacho.kt.passepartout.di.modules.DbRepoModule
import ru.supernacho.kt.passepartout.presenter.AddCatDialogPresenter
import ru.supernacho.kt.passepartout.presenter.ProductPresenter
import ru.supernacho.kt.passepartout.view.ProductSelector
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DbRepoModule::class])
interface AppComponent {
    fun inject(app: App)
    fun inject(activity: ProductSelector)
    fun inject(presenter: ProductPresenter)
    fun inject(presenter: AddCatDialogPresenter)
}