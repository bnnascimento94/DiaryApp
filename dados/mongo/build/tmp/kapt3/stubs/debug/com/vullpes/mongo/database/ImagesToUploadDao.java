package com.vullpes.mongo.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/vullpes/mongo/database/ImagesToUploadDao;", "", "addImageToUpload", "", "imageToUpload", "Lcom/vullpes/mongo/database/entity/ImageToUpload;", "(Lcom/vullpes/mongo/database/entity/ImageToUpload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanupImage", "imageId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllImages", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mongo_debug"})
public abstract interface ImagesToUploadDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM images_to_upload_table ORDER BY id ASC")
    public abstract java.lang.Object getAllImages(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.vullpes.mongo.database.entity.ImageToUpload>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object addImageToUpload(@org.jetbrains.annotations.NotNull()
    com.vullpes.mongo.database.entity.ImageToUpload imageToUpload, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM images_to_upload_table where id=:imageId")
    public abstract java.lang.Object cleanupImage(int imageId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}