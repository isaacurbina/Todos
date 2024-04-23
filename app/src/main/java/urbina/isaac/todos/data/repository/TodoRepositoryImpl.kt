package urbina.isaac.todos.data.repository

import urbina.isaac.todos.data.ApiResult
import urbina.isaac.todos.model.TodoTask
import urbina.isaac.todos.network.retrofit.service.RestApiService

class TodoRepositoryImpl(
    private val restApiService: RestApiService
) : TodoRepository {
    override suspend fun todoTasks(): ApiResult<List<TodoTask>> {
        val response = restApiService.todoTasks()
        return if (response.isSuccessful) {
            val list = response.body()
            if (list.isNullOrEmpty()) {
                ApiResult.Error("received status code 200 but empty list OR failed to parse")
            } else ApiResult.Success(response.body().orEmpty())
        } else {
            val error = response.errorBody()?.string()
            response.errorBody()?.close()
            ApiResult.Error(error.orEmpty())
        }
    }
}
