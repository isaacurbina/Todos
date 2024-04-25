package urbina.isaac.todos.data

sealed class MainScreenState<out T>(
    val status: ApiStatus, val message: String?
) {

    data object Idle : MainScreenState<Nothing>(
        status = ApiStatus.NONE,
        message = null
    )

    data object Loading : MainScreenState<Nothing>(
        status = ApiStatus.LOADING,
        message = null
    )

    data class Success<out R>(val data: R) : MainScreenState<R>(
        status = ApiStatus.SUCCESS,
        message = null
    )

    data class Error(val exception: String) : MainScreenState<Nothing>(
        status = ApiStatus.ERROR,
        message = exception
    )
}