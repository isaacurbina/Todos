package urbina.isaac.todos.network.retrofit.service

import retrofit2.http.GET
import urbina.isaac.todos.model.TodoTask

interface RestApiService {
    @GET("todos")
    suspend fun todoTasks(): List<TodoTask>
}
