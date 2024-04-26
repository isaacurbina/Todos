package urbina.isaac.todos.ui.main.viewmodel

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import urbina.isaac.todos.data.MainScreenAction
import urbina.isaac.todos.data.MainScreenState
import urbina.isaac.todos.data.repository.TodoRepository
import urbina.isaac.todos.model.TodoTask

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    @get:Rule
    val mockkRule = MockKRule(this)

    private lateinit var viewModel: MainViewModel

    @MockK
    lateinit var todoRepository: TodoRepository

    @MockK
    lateinit var todoTask: TodoTask

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true, relaxUnitFun = true)
        viewModel = MainViewModel(
            todoRepository = todoRepository,
            ioDispatcher = Dispatchers.Unconfined
        )
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `handleAction FetchTodoTasks makes network call on repository`() =
        runTest {
            coEvery { todoRepository.todoTasks() } returns MainScreenState.Success(listOf(todoTask))
            val testResults = mutableListOf<MainScreenState<List<TodoTask>>>()

            backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
                viewModel.mainScreenState.toList(testResults)
            }
            viewModel.handleAction(MainScreenAction.FetchTodoTasks)

            coVerify { todoRepository.todoTasks() }
        }

    @Test
    fun `handleAction FetchTodoTasks, when repo fetches data correctly, returns Success`() =
        runTest {
            coEvery { todoRepository.todoTasks() } returns MainScreenState.Success(listOf(todoTask))
            val testResults = mutableListOf<MainScreenState<List<TodoTask>>>()

            backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
                viewModel.mainScreenState.toList(testResults)
            }
            viewModel.handleAction(MainScreenAction.FetchTodoTasks)

            assert(testResults.last() is MainScreenState.Success)
        }

    @Test
    fun `handleAction FetchTodoTasks, when repo cannot fetch data, returns Error`() =
        runTest {
            coEvery { todoRepository.todoTasks() } returns MainScreenState.Error("error message")
            val testResults = mutableListOf<MainScreenState<List<TodoTask>>>()

            backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
                viewModel.mainScreenState.toList(testResults)
            }
            viewModel.handleAction(MainScreenAction.FetchTodoTasks)

            assert(testResults.last() is MainScreenState.Error)
        }
}