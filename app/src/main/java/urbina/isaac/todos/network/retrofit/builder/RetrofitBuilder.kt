package urbina.isaac.todos.network.retrofit.builder

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import urbina.isaac.todos.network.retrofit.service.RestApiService

class RetrofitBuilder {

    private fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: RestApiService = getRetrofit().create(RestApiService::class.java)

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }
}
