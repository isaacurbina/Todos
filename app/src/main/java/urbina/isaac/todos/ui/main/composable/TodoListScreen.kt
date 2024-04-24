package urbina.isaac.todos.ui.main.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import urbina.isaac.todos.data.MainScreenState
import urbina.isaac.todos.model.TodoTask

@Composable
fun TodoListScreen(mainScreenState: MainScreenState.Success<List<TodoTask>>) {
    val dataList = mainScreenState.data.orEmpty()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(1F),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(
            count = dataList.size
        ) { index ->
            val item = dataList[index]
            TodoCard(task = item)
        }
    }
}

@Preview(widthDp = 720, heightDp = 1024)
@Composable
private fun TodoListScreenPreview() {
    val list = listOf(
        TodoTask(
            userId = 12345L,
            id = 23456L,
            title = "My task title 1",
            completed = true
        ),
        TodoTask(
            userId = 12345L,
            id = 23456L,
            title = "My task title 2",
            completed = true
        )
    )
    TodoListScreen(mainScreenState = MainScreenState.Success(list))
}
