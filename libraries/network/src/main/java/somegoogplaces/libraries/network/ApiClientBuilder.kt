package somegoogplaces.libraries.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClientBuilder {
    private val baseClient = OkHttpClient()
    private val defaultGson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create()

    fun <S> createApi(
        apiClass: Class<S>,
        baseUrl: String = BuildConfig.API_URL,
        gson: Gson = defaultGson,
        vararg interceptors: Interceptor
    ): S {
        val builder = baseClient.newBuilder()

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(HttpLoggingInterceptor())
        }

        interceptors.forEach { builder.addInterceptor(it) }

        val client = builder.build()
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(apiClass)
    }
}