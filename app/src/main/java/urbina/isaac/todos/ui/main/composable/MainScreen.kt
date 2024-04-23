package urbina.isaac.todos.ui.main.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import urbina.isaac.todos.data.ApiResult
import urbina.isaac.todos.ui.main.viewmodel.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val result = viewModel.todoList.collectAsState(ApiResult.Loading(isLoading = true))
    when (val apiResult = result.value) {
        is ApiResult.Error -> ErrorScreen(apiResult)
        is ApiResult.Loading -> LoadingScreen()
        is ApiResult.Success -> TodoListScreen(apiResult)
    }
}
