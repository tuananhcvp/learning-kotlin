package com.example.anh.githubadventure.di

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(internal val activity: AppCompatActivity) {

    @Provides
    fun activity(): AppCompatActivity {
        return activity
    }
}
