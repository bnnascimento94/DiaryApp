package com.vullpes.write;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001\u001aP\u0010\u0006\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001\u00a8\u0006\r"}, d2 = {"DeleteDiaryAction", "", "selectedDiary", "Lcom/vullpes/util/model/Diary;", "onDeleteConfirmed", "Lkotlin/Function0;", "WriteTopBar", "moodName", "", "onDateTimeUpdated", "Lkotlin/Function1;", "Ljava/time/ZonedDateTime;", "onBackPressed", "write_debug"})
public final class WriteTopBarKt {
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @android.annotation.SuppressLint(value = {"NewApi"})
    public static final void WriteTopBar(@org.jetbrains.annotations.Nullable()
    com.vullpes.util.model.Diary selectedDiary, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.lang.String> moodName, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.time.ZonedDateTime, kotlin.Unit> onDateTimeUpdated, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteConfirmed, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackPressed) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DeleteDiaryAction(@org.jetbrains.annotations.Nullable()
    com.vullpes.util.model.Diary selectedDiary, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteConfirmed) {
    }
}