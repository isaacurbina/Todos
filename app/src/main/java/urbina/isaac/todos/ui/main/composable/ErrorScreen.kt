package urbina.isaac.todos.ui.main.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import urbina.isaac.todos.R
import urbina.isaac.todos.data.MainScreenAction
import urbina.isaac.todos.data.MainScreenState

@Composable
fun ErrorScreen(
    error: MainScreenState.Error,
    handleAction: (action: MainScreenAction) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = error.exception,
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            ),
            textAlign = TextAlign.Center
        )
        Button(
            onClick = {
                handleAction(MainScreenAction.FetchTodoTasks)
            }
        ) {
            Text(
                text = stringResource(R.string.todos_retry),
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
private fun ErrorScreenPreview() {
    ErrorScreen(
        error = MainScreenState.Error("Error on API call goes here")
    ) {
        // NOOP
    }
}
