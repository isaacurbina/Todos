package urbina.isaac.todos.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import urbina.isaac.todos.data.ApiResult
import urbina.isaac.todos.data.repository.TodoRepository
import urbina.isaac.todos.model.TodoTask

class MainViewModel(
    private val todoRepository: TodoRepository,
    ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    val todoList: Flow<ApiResult<List<TodoTask>>> = flow {
        emit(ApiResult.Loading(true))
        delay(5000L)
        val response = withContext(ioDispatcher) { todoRepository.todoTasks() }
        emit(response)
    }
}
