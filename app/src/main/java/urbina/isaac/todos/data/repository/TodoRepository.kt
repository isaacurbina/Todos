package urbina.isaac.todos.data.repository

import urbina.isaac.todos.model.TodoTask

interface TodoRepository {
    suspend fun todoTasks(): List<TodoTask>
}
