package urbina.isaac.todos.ui.main.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import urbina.isaac.todos.data.MainScreenAction
import urbina.isaac.todos.data.MainScreenState
import urbina.isaac.todos.ui.main.viewmodel.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    handleAction: (action: MainScreenAction) -> Unit
) {
    val result = viewModel.mainScreenState.collectAsState(MainScreenState.Idle)
    when (val apiResult = result.value) {
        is MainScreenState.Idle -> StartScreen(handleAction = handleAction)
        is MainScreenState.Loading -> LoadingScreen()
        is MainScreenState.Success -> TodoListScreen(mainScreenState = apiResult)
        is MainScreenState.Error -> ErrorScreen(error = apiResult, handleAction = handleAction)
    }
}
