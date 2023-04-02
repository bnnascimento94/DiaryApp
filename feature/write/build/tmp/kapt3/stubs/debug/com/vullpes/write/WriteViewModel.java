package com.vullpes.write;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ(\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00170!J\u001a\u0010\"\u001a\u00020\u00172\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010$H\u0002J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001bH\u0002J\b\u0010\'\u001a\u00020\u0017H\u0002J\b\u0010(\u001a\u00020\u0017H\u0002J;\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00170!H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,J\u000e\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u001bJ\u0010\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+H\u0002J\u000e\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u001bJ\b\u00105\u001a\u00020\u0017H\u0002J\u0010\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u000208H\u0007J;\u00109\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00170!H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,J0\u0010:\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00170!R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006;"}, d2 = {"Lcom/vullpes/write/WriteViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "imagesToUploadDao", "Lcom/vullpes/mongo/database/ImagesToUploadDao;", "imageToDeleteDao", "Lcom/vullpes/mongo/database/ImageToDeleteDao;", "(Landroidx/lifecycle/SavedStateHandle;Lcom/vullpes/mongo/database/ImagesToUploadDao;Lcom/vullpes/mongo/database/ImageToDeleteDao;)V", "galleryState", "Lcom/vullpes/ui/GalleryState;", "getGalleryState", "()Lcom/vullpes/ui/GalleryState;", "<set-?>", "Lcom/vullpes/write/UiState;", "uiState", "getUiState", "()Lcom/vullpes/write/UiState;", "setUiState", "(Lcom/vullpes/write/UiState;)V", "uiState$delegate", "Landroidx/compose/runtime/MutableState;", "addImage", "", "image", "Landroid/net/Uri;", "imageType", "", "deleteDiary", "Lkotlinx/coroutines/Job;", "onSuccess", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "deleteImagesFromFirebase", "images", "", "extractRemoteImagePath", "fullImageUrl", "fetchSelectedDiary", "getDairyArgument", "insertDiary", "diary", "Lcom/vullpes/util/model/Diary;", "(Lcom/vullpes/util/model/Diary;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDescription", "description", "setMood", "mood", "Lcom/vullpes/util/model/Mood;", "setSelectedDiary", "setTitle", "title", "upLoadImagesToFirebase", "updateDateTime", "zonedDateTime", "Ljava/time/ZonedDateTime;", "updateDiary", "upsertDiary", "write_debug"})
public final class WriteViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.SavedStateHandle savedStateHandle = null;
    private final com.vullpes.mongo.database.ImagesToUploadDao imagesToUploadDao = null;
    private final com.vullpes.mongo.database.ImageToDeleteDao imageToDeleteDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.vullpes.ui.GalleryState galleryState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState uiState$delegate = null;
    
    @javax.inject.Inject()
    public WriteViewModel(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle, @org.jetbrains.annotations.NotNull()
    com.vullpes.mongo.database.ImagesToUploadDao imagesToUploadDao, @org.jetbrains.annotations.NotNull()
    com.vullpes.mongo.database.ImageToDeleteDao imageToDeleteDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.vullpes.ui.GalleryState getGalleryState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.vullpes.write.UiState getUiState() {
        return null;
    }
    
    private final void setUiState(com.vullpes.write.UiState p0) {
    }
    
    private final void getDairyArgument() {
    }
    
    private final void fetchSelectedDiary() {
    }
    
    private final java.lang.String extractRemoteImagePath(java.lang.String fullImageUrl) {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    public final void setDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String description) {
    }
    
    private final void setMood(com.vullpes.util.model.Mood mood) {
    }
    
    private final void setSelectedDiary(com.vullpes.util.model.Diary diary) {
    }
    
    @android.annotation.SuppressLint(value = {"NewApi"})
    public final void updateDateTime(@org.jetbrains.annotations.NotNull()
    java.time.ZonedDateTime zonedDateTime) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job upsertDiary(@org.jetbrains.annotations.NotNull()
    com.vullpes.util.model.Diary diary, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
        return null;
    }
    
    private final java.lang.Object insertDiary(com.vullpes.util.model.Diary diary, kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object updateDiary(com.vullpes.util.model.Diary diary, kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteDiary(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
        return null;
    }
    
    public final void addImage(@org.jetbrains.annotations.NotNull()
    android.net.Uri image, @org.jetbrains.annotations.NotNull()
    java.lang.String imageType) {
    }
    
    private final void upLoadImagesToFirebase() {
    }
    
    private final void deleteImagesFromFirebase(java.util.List<java.lang.String> images) {
    }
}