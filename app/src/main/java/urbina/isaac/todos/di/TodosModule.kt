package urbina.isaac.todos.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import urbina.isaac.todos.data.repository.TodoRepository
import urbina.isaac.todos.network.retrofit.service.RestApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TodosModule {

    @Singleton
    @Provides
    fun provideTodoRepository(restApiService: RestApiService): TodoRepository =
        TodoRepository.getInstance(restApiService)

    @Singleton
    @Provides
    fun provideRestApiService(): RestApiService = RestApiService.getInstance()

    @Singleton
    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}
