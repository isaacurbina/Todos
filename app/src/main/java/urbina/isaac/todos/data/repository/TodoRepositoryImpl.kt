package urbina.isaac.todos.data.repository

import urbina.isaac.todos.data.MainScreenState
import urbina.isaac.todos.model.TodoTask
import urbina.isaac.todos.network.retrofit.service.RestApiService

class TodoRepositoryImpl(
    private val restApiService: RestApiService
) : TodoRepository {

    override suspend fun todoTasks(): MainScreenState<List<TodoTask>> {
        val result = try {
            val response = restApiService.todoTasks()
            if (response.isSuccessful) {
                val list = response.body()
                if (list.isNullOrEmpty()) {
                    MainScreenState.Error("received status code 200 but empty list OR failed to parse")
                } else MainScreenState.Success(response.body().orEmpty())
            } else {
                val error = response.errorBody()?.string()
                response.errorBody()?.close()
                MainScreenState.Error(error.orEmpty())
            }
        } catch (e: Exception) {
            MainScreenState.Error(e.localizedMessage ?: "Error on network call")
        }
        return result
    }
}
