package urbina.isaac.todos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import urbina.isaac.todos.data.repository.TodoRepositoryImpl
import urbina.isaac.todos.network.retrofit.service.RestApiService
import urbina.isaac.todos.ui.main.composable.MainScreen
import urbina.isaac.todos.ui.main.viewmodel.MainViewModel
import urbina.isaac.todos.ui.theme.TodosTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by lazy {
        // TODO(Isaac) - use Hilt to inject this dependency
        MainViewModel(TodoRepositoryImpl(RestApiService.getInstance()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(viewModel = viewModel)
                }
            }
        }
    }
}
