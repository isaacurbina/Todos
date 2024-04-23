package urbina.isaac.todos.data.repository

import urbina.isaac.todos.model.TodoTask
import urbina.isaac.todos.network.retrofit.service.RestApiService

class TodoRepositoryImpl(
    private val restApiService: RestApiService
) : TodoRepository {
    override suspend fun todoTasks(): List<TodoTask> =
        restApiService.todoTasks()
}
