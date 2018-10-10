package ru.supernacho.kt.passepartout.di.modules

import dagger.Module
import dagger.Provides
import ru.supernacho.kt.passepartout.model.repository.DbRepository
import ru.supernacho.kt.passepartout.model.repository.DbRoom
import javax.inject.Singleton

@Singleton
@Module(includes = [RoomModule::class])
class DbRepoModule {
    @Provides
    fun dbRepository(dbRoom: DbRoom) = DbRepository(dbRoom)
}