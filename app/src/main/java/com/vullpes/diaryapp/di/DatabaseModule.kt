package com.vullpes.diaryapp.di

import android.content.Context
import androidx.room.Room
import com.vullpes.mongo.database.ImageToDeleteDao
import com.vullpes.mongo.database.ImagesDataBase
import com.vullpes.mongo.database.ImagesToUploadDao
import com.vullpes.util.Constants.IMAGES_DATABASE
import com.vullpes.util.conectivity.NetworkConectivityObserver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): ImagesDataBase {
        return Room.databaseBuilder(
            context = context,
            klass = ImagesDataBase::class.java,
            name = IMAGES_DATABASE
        ).build()
    }

    @Singleton
    @Provides
    fun provideFirstDao(dataBase: ImagesDataBase): ImagesToUploadDao = dataBase.imageToUploadDao()

    @Singleton
    @Provides
    fun provideSecondDao(dataBase: ImagesDataBase): ImageToDeleteDao = dataBase.imageToDeleteDao()

    @Singleton
    @Provides
    fun provideNetworkConnectivityObserver(
        @ApplicationContext context: Context
    ) = NetworkConectivityObserver(context = context)
}