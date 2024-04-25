package urbina.isaac.todos.data

sealed class MainScreenAction {
    data object FetchTodoTasks : MainScreenAction()
}
