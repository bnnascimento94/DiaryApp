package com.vullpes.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u00aa\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\"\u0010\b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\n0\tj\u0002`\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001\u001a?\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005\u00a2\u0006\u0002\b\u001aH\u0001\u00a8\u0006\u001b"}, d2 = {"HomeScreen", "", "drawerState", "Landroidx/compose/material3/DrawerState;", "onSignOutClicked", "Lkotlin/Function0;", "onMenuClicked", "navigateToWrite", "diaries", "Lcom/vullpes/util/model/RequestState;", "", "Ljava/time/LocalDate;", "", "Lcom/vullpes/util/model/Diary;", "Lcom/vullpes/mongo/repository/Diaries;", "navigateToWriteWithArgs", "Lkotlin/Function1;", "", "onDeleteAllClicked", "dateIsSelected", "", "onDateSelected", "Ljava/time/ZonedDateTime;", "onDateReset", "NavigationDrawer", "content", "Landroidx/compose/runtime/Composable;", "home_debug"})
public final class HomeScreenKt {
    
    @androidx.compose.runtime.Composable()
    @android.annotation.SuppressLint(value = {"UnusedMaterial3ScaffoldPaddingParameter"})
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull()
    androidx.compose.material3.DrawerState drawerState, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSignOutClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onMenuClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> navigateToWrite, @org.jetbrains.annotations.NotNull()
    com.vullpes.util.model.RequestState<? extends java.util.Map<java.time.LocalDate, ? extends java.util.List<? extends com.vullpes.util.model.Diary>>> diaries, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> navigateToWriteWithArgs, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteAllClicked, boolean dateIsSelected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.time.ZonedDateTime, kotlin.Unit> onDateSelected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDateReset) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void NavigationDrawer(@org.jetbrains.annotations.NotNull()
    androidx.compose.material3.DrawerState drawerState, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSignOutClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteAllClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> content) {
    }
}