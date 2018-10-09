package ru.supernacho.kt.passepartout.di.modules

import dagger.Module
import dagger.Provides
import ru.supernacho.kt.passepartout.App

@Module
class AppModule(private val app: App) {
    @Provides
    fun app() = app
}