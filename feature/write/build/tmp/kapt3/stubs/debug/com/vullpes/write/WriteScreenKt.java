package com.vullpes.write;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u00c2\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\nH\u0001\u001a,\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001\u00a8\u0006\u001c"}, d2 = {"WriteScreen", "", "uiState", "Lcom/vullpes/write/UiState;", "onDeleteConfirmed", "Lkotlin/Function0;", "onBackPressed", "pagerState", "Lcom/google/accompanist/pager/PagerState;", "ontitleChanged", "Lkotlin/Function1;", "", "onDescriptionChanged", "moodName", "onSaveClicked", "Lcom/vullpes/util/model/Diary;", "onDateTimeUpdated", "Ljava/time/ZonedDateTime;", "galleryState", "Lcom/vullpes/ui/GalleryState;", "onImageSelect", "Landroid/net/Uri;", "onImageDeleteClicked", "Lcom/vullpes/ui/GalleryImage;", "ZoomableImage", "selectedGalleryImage", "onCloseClicked", "onDeleteClicked", "write_debug"})
public final class WriteScreenKt {
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class, com.google.accompanist.pager.ExperimentalPagerApi.class})
    @android.annotation.SuppressLint(value = {"UnusedMaterial3ScaffoldPaddingParameter"})
    public static final void WriteScreen(@org.jetbrains.annotations.NotNull()
    com.vullpes.write.UiState uiState, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteConfirmed, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackPressed, @org.jetbrains.annotations.NotNull()
    com.google.accompanist.pager.PagerState pagerState, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> ontitleChanged, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDescriptionChanged, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.lang.String> moodName, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.vullpes.util.model.Diary, kotlin.Unit> onSaveClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.time.ZonedDateTime, kotlin.Unit> onDateTimeUpdated, @org.jetbrains.annotations.NotNull()
    com.vullpes.ui.GalleryState galleryState, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.net.Uri, kotlin.Unit> onImageSelect, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.vullpes.ui.GalleryImage, kotlin.Unit> onImageDeleteClicked) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ZoomableImage(@org.jetbrains.annotations.NotNull()
    com.vullpes.ui.GalleryImage selectedGalleryImage, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onCloseClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteClicked) {
    }
}