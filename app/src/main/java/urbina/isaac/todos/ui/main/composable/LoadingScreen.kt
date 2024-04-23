package urbina.isaac.todos.ui.main.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier
            .wrapContentSize(),
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(64.dp),
            strokeWidth = 8.dp
        )
    }
}

@Preview(widthDp = 720, heightDp = 1024)
@Composable
private fun LoadingScreenPreview() {
    LoadingScreen()
}
