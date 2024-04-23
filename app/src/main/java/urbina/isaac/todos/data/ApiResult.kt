package urbina.isaac.todos.data

sealed class ApiResult<out T>(
    val status: ApiStatus, val data: T?, val message: String?
) {
    data class Success<out R>(val newData: R) : ApiResult<R>(
        status = ApiStatus.SUCCESS,
        data = newData,
        message = null
    )

    data class Error(val exception: String) : ApiResult<Nothing>(
        status = ApiStatus.ERROR,
        data = null,
        message = exception
    )

    data class Loading<out R>(val isLoading: Boolean, val newData: R? = null) : ApiResult<R>(
        status = ApiStatus.LOADING,
        data = newData,
        message = null
    )
}