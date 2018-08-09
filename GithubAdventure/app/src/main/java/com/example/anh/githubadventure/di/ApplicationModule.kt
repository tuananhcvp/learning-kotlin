package com.example.anh.githubadventure.di

import android.app.Application
import android.content.Context
import com.example.anh.githubadventure.BuildConfig
import com.example.anh.githubadventure.api.GithubRepository
import com.example.anh.githubadventure.api.GithubRepositoryInterface
import com.example.anh.githubadventure.api.PlatformAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    companion object {
        val BASE_URL = "https://api.github.com/"
    }

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun providePlatformAPI(): PlatformAPI {
        val interceptor = HttpLoggingInterceptor();
        interceptor.setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE);

        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build()

        return retrofit.create<PlatformAPI>(PlatformAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideGithubRepositoryInterface(platformAPI: PlatformAPI): GithubRepositoryInterface {
        return GithubRepository(platformAPI)
    }

}
