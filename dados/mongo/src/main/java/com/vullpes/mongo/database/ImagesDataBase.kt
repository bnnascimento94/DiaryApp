package com.vullpes.mongo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vullpes.mongo.database.entity.ImageToDelete
import com.vullpes.mongo.database.entity.ImageToUpload

@Database(entities = [ImageToUpload::class, ImageToDelete::class], version = 2, exportSchema = false)
abstract class ImagesDataBase: RoomDatabase() {
    abstract fun imageToUploadDao(): ImagesToUploadDao
    abstract fun imageToDeleteDao(): ImageToDeleteDao
}