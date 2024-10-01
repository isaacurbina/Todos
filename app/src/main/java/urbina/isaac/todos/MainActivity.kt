package urbina.isaac.todos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import urbina.isaac.todos.ui.main.composable.MainScreen
import urbina.isaac.todos.ui.main.viewmodel.MainViewModel
import urbina.isaac.todos.ui.theme.TodosTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodosTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LaunchedEffect(key1 = viewModel) {
                        lifecycleScope.launch {
                            repeatOnLifecycle(Lifecycle.State.STARTED) {
                                viewModel.mainScreenAction.consumeAsFlow().collect {
                                    viewModel.handleAction(it)
                                }
                            }
                        }
                    }
                    MainScreen(viewModel = viewModel) {
                        lifecycleScope.launch {
                            viewModel.mainScreenAction.send(it)
                        }
                    }
                }
            }
        }
    }
}
