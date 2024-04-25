package urbina.isaac.todos.ui.main.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import urbina.isaac.todos.R
import urbina.isaac.todos.data.MainScreenAction

@Composable
fun StartScreen(
    handleAction: (action: MainScreenAction) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = {
                handleAction(MainScreenAction.FetchTodoTasks)
            },
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(
                text = stringResource(R.string.todos_fetch_data),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
        }
    }
}

@Preview(widthDp = 720, heightDp = 1024)
@Composable
private fun StartScreenPreview() {
    StartScreen {
        // NOOP
    }
}
