package urbina.isaac.todos.network.retrofit.service

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import urbina.isaac.todos.model.TodoTask

interface RestApiService {
    @GET("todos")
    suspend fun todoTasks(): Response<List<TodoTask>>

    companion object {

        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        private fun getRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun getInstance(): RestApiService = getRetrofit().create(RestApiService::class.java)
    }
}
