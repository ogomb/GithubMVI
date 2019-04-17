package com.example.githubmvi.data.repository

import android.content.Context
import com.example.githubmvi.data.model.GithubRepo
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import android.R.attr.password
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.io.IOException


open class BaseRetrofitModule(
    val context: Context,
    baseUrl: String,
    username: String,
    password: String ) {

    private var gson = GsonBuilder()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
        .registerTypeAdapter(GithubRepo::class.java, GithubRepoDeserializer())
        .create()

    var okHttpClient = OkHttpClient.Builder()
        .addInterceptor(object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
                val originalRequest = chain.request()

                val builder = originalRequest.newBuilder().header(
                    "Authorization",
                    Credentials.basic(username, password)
                )

                val newRequest = builder.build()
                return chain.proceed(newRequest)
            }
        }).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}