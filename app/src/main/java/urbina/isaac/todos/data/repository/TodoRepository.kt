package urbina.isaac.todos.data.repository

import urbina.isaac.todos.data.MainScreenState
import urbina.isaac.todos.model.TodoTask
import urbina.isaac.todos.network.retrofit.service.RestApiService

interface TodoRepository {
    suspend fun todoTasks(): MainScreenState<List<TodoTask>>

    companion object {
        fun getInstance(restApiService: RestApiService): TodoRepository =
            TodoRepositoryImpl(restApiService)
    }
}
