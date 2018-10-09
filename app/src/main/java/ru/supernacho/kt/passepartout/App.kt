package ru.supernacho.kt.passepartout

import android.app.Application
import ru.supernacho.kt.passepartout.di.AppComponent
import ru.supernacho.kt.passepartout.di.DaggerAppComponent
import ru.supernacho.kt.passepartout.di.modules.AppModule

class App : Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}