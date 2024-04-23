package urbina.isaac.todos.ui.main.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import urbina.isaac.todos.data.ApiResult

@Composable
fun ErrorScreen(result: ApiResult.Error) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = result.exception,
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = Color.DarkGray
            )
        )
    }
}

@Preview(widthDp = 720, heightDp = 1024)
@Composable
private fun ErrorScreenPreview() {
    ErrorScreen(
        result = ApiResult.Error("Error on API call goes here")
    )
}
