package ru.supernacho.kt.passepartout.di.modules

import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import ru.supernacho.kt.passepartout.App
import ru.supernacho.kt.passepartout.model.repository.DbRoom
import javax.inject.Singleton

@Singleton
@Module(includes = [AppModule::class])
class RoomModule {
    @Provides
    fun dbRoom(app: App) = Room.databaseBuilder(app.applicationContext, DbRoom::class.java, "products").build()

}