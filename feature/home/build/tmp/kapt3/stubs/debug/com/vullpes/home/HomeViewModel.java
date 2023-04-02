package com.vullpes.home;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J(\u0010&\u001a\u00020\'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\'0)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\'0+J\u0012\u0010\u001a\u001a\u00020\'2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.J\b\u0010/\u001a\u00020\'H\u0002J\u0010\u00100\u001a\u00020\'2\u0006\u0010-\u001a\u00020.H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR<\u0010\u0012\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00150\u0014j\u0002`\u00190\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010 \u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\u001f8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b%\u0010\u0011\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u00061"}, d2 = {"Lcom/vullpes/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "connectivity", "Lcom/vullpes/util/conectivity/NetworkConectivityObserver;", "imageToDeleteDao", "Lcom/vullpes/mongo/database/ImageToDeleteDao;", "(Lcom/vullpes/util/conectivity/NetworkConectivityObserver;Lcom/vullpes/mongo/database/ImageToDeleteDao;)V", "allDiariesJob", "Lkotlinx/coroutines/Job;", "<set-?>", "", "dateIsSelected", "getDateIsSelected", "()Z", "setDateIsSelected", "(Z)V", "dateIsSelected$delegate", "Landroidx/compose/runtime/MutableState;", "diaries", "Landroidx/compose/runtime/MutableState;", "Lcom/vullpes/util/model/RequestState;", "", "Ljava/time/LocalDate;", "", "Lcom/vullpes/util/model/Diary;", "Lcom/vullpes/mongo/repository/Diaries;", "getDiaries", "()Landroidx/compose/runtime/MutableState;", "setDiaries", "(Landroidx/compose/runtime/MutableState;)V", "filteredDiariesJob", "Lcom/vullpes/util/conectivity/ConectivityObserver$Status;", "network", "getNetwork", "()Lcom/vullpes/util/conectivity/ConectivityObserver$Status;", "setNetwork", "(Lcom/vullpes/util/conectivity/ConectivityObserver$Status;)V", "network$delegate", "deleteAllDiaries", "", "onSuccess", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "", "zonedDateTime", "Ljava/time/ZonedDateTime;", "observeAllDiaries", "observeFilteredDiaries", "home_debug"})
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    private final com.vullpes.util.conectivity.NetworkConectivityObserver connectivity = null;
    private final com.vullpes.mongo.database.ImageToDeleteDao imageToDeleteDao = null;
    private final androidx.compose.runtime.MutableState network$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<com.vullpes.util.model.RequestState<java.util.Map<java.time.LocalDate, java.util.List<com.vullpes.util.model.Diary>>>> diaries;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState dateIsSelected$delegate = null;
    private kotlinx.coroutines.Job allDiariesJob;
    private kotlinx.coroutines.Job filteredDiariesJob;
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    com.vullpes.util.conectivity.NetworkConectivityObserver connectivity, @org.jetbrains.annotations.NotNull()
    com.vullpes.mongo.database.ImageToDeleteDao imageToDeleteDao) {
        super();
    }
    
    private final com.vullpes.util.conectivity.ConectivityObserver.Status getNetwork() {
        return null;
    }
    
    private final void setNetwork(com.vullpes.util.conectivity.ConectivityObserver.Status p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<com.vullpes.util.model.RequestState<java.util.Map<java.time.LocalDate, java.util.List<com.vullpes.util.model.Diary>>>> getDiaries() {
        return null;
    }
    
    public final void setDiaries(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<com.vullpes.util.model.RequestState<java.util.Map<java.time.LocalDate, java.util.List<com.vullpes.util.model.Diary>>>> p0) {
    }
    
    public final boolean getDateIsSelected() {
        return false;
    }
    
    private final void setDateIsSelected(boolean p0) {
    }
    
    public final void getDiaries(@org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime zonedDateTime) {
    }
    
    private final void observeAllDiaries() {
    }
    
    private final void observeFilteredDiaries(java.time.ZonedDateTime zonedDateTime) {
    }
    
    public final void deleteAllDiaries(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onError) {
    }
}