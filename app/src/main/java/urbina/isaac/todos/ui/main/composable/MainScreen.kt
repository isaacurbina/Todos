package urbina.isaac.todos.ui.main.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import urbina.isaac.todos.data.MainScreenState
import urbina.isaac.todos.ui.main.viewmodel.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val result = viewModel.todoList.collectAsState(MainScreenState.Loading(isLoading = true))
    when (val apiResult = result.value) {
        is MainScreenState.Error -> ErrorScreen(apiResult)
        is MainScreenState.Loading -> LoadingScreen()
        is MainScreenState.Success -> TodoListScreen(apiResult)
        is MainScreenState.Idle -> TODO("Isaac - add idle page with a button click for MVI")
    }
}
