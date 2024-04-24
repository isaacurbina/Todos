package urbina.isaac.todos.data

sealed class MainScreenState<out T>(
    val status: ApiStatus, val data: T?, val message: String?
) {

    data class Idle(val x: Boolean) : MainScreenState<Nothing>(
        status = ApiStatus.NONE,
        data = null,
        message = null
    )

    data class Success<out R>(val newData: R) : MainScreenState<R>(
        status = ApiStatus.SUCCESS,
        data = newData,
        message = null
    )

    data class Error(val exception: String) : MainScreenState<Nothing>(
        status = ApiStatus.ERROR,
        data = null,
        message = exception
    )

    data class Loading<out R>(val isLoading: Boolean, val newData: R? = null) : MainScreenState<R>(
        status = ApiStatus.LOADING,
        data = newData,
        message = null
    )
}