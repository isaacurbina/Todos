package urbina.isaac.todos.ui.main.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import urbina.isaac.todos.data.ApiResult
import urbina.isaac.todos.model.TodoTask

@Composable
fun TodoListScreen(apiResult: ApiResult.Success<List<TodoTask>>) {
    val dataList = apiResult.data.orEmpty()
    LazyColumn(
        modifier = Modifier.fillMaxSize(1F)
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
    TodoListScreen(apiResult = ApiResult.Success(list))
}
