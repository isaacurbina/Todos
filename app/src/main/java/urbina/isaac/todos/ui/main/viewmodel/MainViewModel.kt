package urbina.isaac.todos.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import urbina.isaac.todos.data.MainScreenAction
import urbina.isaac.todos.data.MainScreenState
import urbina.isaac.todos.data.repository.TodoRepository
import urbina.isaac.todos.model.TodoTask
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val todoRepository: TodoRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    val mainScreenAction = Channel<MainScreenAction>(Channel.UNLIMITED)

    private val _mainScreenState =
        MutableStateFlow<MainScreenState<List<TodoTask>>>(MainScreenState.Idle)
    val mainScreenState: StateFlow<MainScreenState<List<TodoTask>>> = _mainScreenState.asStateFlow()

    fun handleAction(action: MainScreenAction) = viewModelScope.launch(ioDispatcher) {
        when (action) {
            MainScreenAction.FetchTodoTasks -> fetchTodoTasks()
        }
    }

    private suspend fun fetchTodoTasks() {
        _mainScreenState.emit(MainScreenState.Loading)
        val response = withContext(ioDispatcher) { todoRepository.todoTasks() }
        _mainScreenState.emit(response)
    }
}
