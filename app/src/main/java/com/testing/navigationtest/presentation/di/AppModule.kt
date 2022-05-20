package com.testing.navigationtest.presentation.di

import com.testing.navigationtest.SomeRepo
import com.testing.navigationtest.SomeRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import javax.xml.transform.Source

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    abstract fun bindSomeRepo(source: SomeRepoImpl): SomeRepo
}