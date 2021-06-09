package com.habib.githubuser.network
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {
    private const val BASE_URL = "https://api.github.com/"
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(getHttpClient())
        .build()

    val apiInstance = retrofit.create(ApiService::class.java)

    private fun getHttpClient(): OkHttpClient {
        val defaulTimeOut = 30L
        return OkHttpClient.Builder()
            .connectTimeout(defaulTimeOut, TimeUnit.SECONDS)
            .writeTimeout(defaulTimeOut, TimeUnit.SECONDS)
            .readTimeout(defaulTimeOut, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }
}