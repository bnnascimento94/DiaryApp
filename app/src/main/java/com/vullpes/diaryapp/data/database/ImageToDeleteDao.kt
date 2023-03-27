package com.vullpes.diaryapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vullpes.diaryapp.data.database.entity.ImageToDelete
import com.vullpes.diaryapp.data.database.entity.ImageToUpload

@Dao
interface ImageToDeleteDao {
    @Query("SELECT * FROM image_to_delete_table ORDER BY id ASC")
    suspend fun getAllImages(): List<ImageToDelete>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImageToDelete(imageToDelete: ImageToDelete)

    @Query("DELETE FROM image_to_delete_table where id=:imageId")
    suspend fun cleanupImageToDelete(imageId: Int)
}