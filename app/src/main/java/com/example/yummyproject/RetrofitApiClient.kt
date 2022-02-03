package com.example.yummyproject
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitApiClient {

    companion object {
        var retrofit: Retrofit? = null
        fun createRetrofitAPI(baseUrl: String) : APIMethodInterface{
            var logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
            httpClient.connectTimeout(60, TimeUnit.SECONDS)
            httpClient.readTimeout(60, TimeUnit.SECONDS)
            retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit!!.create(APIMethodInterface::class.java)
        }

        fun getRetrofitModel(): Retrofit{
            return retrofit!!
        }
    }

}