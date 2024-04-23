package urbina.isaac.todos.data.repository

import urbina.isaac.todos.data.ApiResult
import urbina.isaac.todos.model.TodoTask

interface TodoRepository {
    suspend fun todoTasks(): ApiResult<List<TodoTask>>
}
