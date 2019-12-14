package com.example.ahasan.movieApp.DI.modules

import android.content.Context
import com.example.ahasan.movieApp.DI.DetailsViewModelModule
import com.example.ahasan.movieApp.Interfaces.MovieDetailsAPI
import com.example.ahasan.movieApp.DetailsScreen.View.DetailsActivity
import com.example.ahasan.movieApp.DI.annotations.ActivityContext
import com.example.ahasan.movieApp.DI.annotations.RetrofitMovie
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit

@Module
internal abstract class DetailsActivityModule {
    @ContributesAndroidInjector
        (
        modules = arrayOf(
         provideDetailsActivityContext::class,
           RetrofitReviewModule::class,
            DetailsViewModelModule::class
        )
    )
    internal abstract fun contributeMainActivity(): DetailsActivity
}

@Module
class provideDetailsActivityContext {
    @Provides
    @ActivityContext
    fun provideActivityContext(activity: DetailsActivity): Context {
        return activity
    }
}

@Module
class RetrofitReviewModule {
    @Provides
    fun getReviewResponce(@RetrofitMovie retrofit: Retrofit): MovieDetailsAPI {
        return retrofit.create(MovieDetailsAPI::class.java)
    }
}





