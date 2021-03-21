package com.masudinn.news_app.core.di.Modul



import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.masudinn.news_app.core.network.ResponseHttpLogging
import com.masudinn.news_app.core.network.Service.NewsService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    var Api_Key = "6c687dac35bc4f8cb79d797d61704a72"
    var Base_Url = "https://newsapi.org/v2/"

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideInterceptor(): Interceptor {
        return Interceptor { chain ->
            val builderNew = chain.request().newBuilder()
            builderNew.addHeader("Accept", "application/json")
            builderNew.addHeader("Content-Type", "application/json")
            builderNew.addHeader("x-api-key", Api_Key)
            val requestNew = builderNew.build()
            chain.proceed(requestNew)
        }
    }

    @Provides
    @Singleton
    fun provideHttpLogging(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(ResponseHttpLogging())
            .apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    @Provides
    @Singleton
    fun provideOkHttpBuilder(
        interceptor: Interceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .followRedirects(false)
            .addInterceptor(interceptor)
//            .apply { if (BuildConfig.DEBUG) addNetworkInterceptor(httpLoggingInterceptor) }
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        gson: Gson,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsService(retrofit: Retrofit): NewsService =
        retrofit.create(NewsService::class.java)
}