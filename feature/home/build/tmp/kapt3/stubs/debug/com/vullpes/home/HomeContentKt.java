package com.vullpes.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u001c\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0001\u001a>\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0010H\u0001\u00a8\u0006\u0011"}, d2 = {"DateHeader", "", "localDate", "Ljava/time/LocalDate;", "EmptyPage", "title", "", "subtitle", "HomeContent", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "diariesNotes", "", "", "Lcom/vullpes/util/model/Diary;", "onCLick", "Lkotlin/Function1;", "home_debug"})
public final class HomeContentKt {
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    public static final void HomeContent(@org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.layout.PaddingValues paddingValues, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.time.LocalDate, ? extends java.util.List<? extends com.vullpes.util.model.Diary>> diariesNotes, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onCLick) {
    }
    
    @androidx.compose.runtime.Composable()
    @android.annotation.SuppressLint(value = {"NewApi"})
    public static final void DateHeader(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate localDate) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void EmptyPage(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String subtitle) {
    }
}