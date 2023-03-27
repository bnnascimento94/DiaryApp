package com.vullpes.diaryapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vullpes.diaryapp.data.database.entity.ImageToDelete
import com.vullpes.diaryapp.data.database.entity.ImageToUpload

@Database(entities = [ImageToUpload::class, ImageToDelete::class], version = 2, exportSchema = false)
abstract class ImagesDataBase: RoomDatabase() {
    abstract fun imageToUploadDao(): ImagesToUploadDao
    abstract fun imageToDeleteDao(): ImageToDeleteDao
}