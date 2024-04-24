package urbina.isaac.todos.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import urbina.isaac.todos.data.MainScreenState
import urbina.isaac.todos.data.repository.TodoRepository
import urbina.isaac.todos.model.TodoTask
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    todoRepository: TodoRepository,
    ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    val todoList: Flow<MainScreenState<List<TodoTask>>> = flow {
        emit(MainScreenState.Loading(true))
        delay(5000L)
        val response = withContext(ioDispatcher) { todoRepository.todoTasks() }
        emit(response)
    }
}
