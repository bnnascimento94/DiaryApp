package com.vullpes.mongo.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\n\u001a\u00020\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ*\u0010\r\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u000f0\u0005j\u0002`\u00120\u000eH&J2\u0010\u0013\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u000f0\u0005j\u0002`\u00120\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u000e2\u0006\u0010\u0017\u001a\u00020\u000bH&J\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\u0019\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\u0019\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/vullpes/mongo/repository/MongoRepository;", "", "configureTheRealm", "", "deleteAllDiaries", "Lcom/vullpes/util/model/RequestState;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDiary", "Lcom/vullpes/util/model/Diary;", "id", "Lio/realm/kotlin/types/ObjectId;", "(Lio/realm/kotlin/types/ObjectId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllDiaries", "Lkotlinx/coroutines/flow/Flow;", "", "Ljava/time/LocalDate;", "", "Lcom/vullpes/mongo/repository/Diaries;", "getFilteredDiaries", "zonedDateTime", "Ljava/time/ZonedDateTime;", "getSelectedDiary", "diaryId", "insertDiary", "diary", "(Lcom/vullpes/util/model/Diary;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDiary", "mongo_debug"})
public abstract interface MongoRepository {
    
    public abstract void configureTheRealm();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.vullpes.util.model.RequestState<java.util.Map<java.time.LocalDate, java.util.List<com.vullpes.util.model.Diary>>>> getAllDiaries();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.vullpes.util.model.RequestState<java.util.Map<java.time.LocalDate, java.util.List<com.vullpes.util.model.Diary>>>> getFilteredDiaries(@org.jetbrains.annotations.NotNull()
    java.time.ZonedDateTime zonedDateTime);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.vullpes.util.model.RequestState<com.vullpes.util.model.Diary>> getSelectedDiary(@org.jetbrains.annotations.NotNull()
    io.realm.kotlin.types.ObjectId diaryId);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertDiary(@org.jetbrains.annotations.NotNull()
    com.vullpes.util.model.Diary diary, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.vullpes.util.model.RequestState<? extends com.vullpes.util.model.Diary>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateDiary(@org.jetbrains.annotations.NotNull()
    com.vullpes.util.model.Diary diary, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.vullpes.util.model.RequestState<? extends com.vullpes.util.model.Diary>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteDiary(@org.jetbrains.annotations.NotNull()
    io.realm.kotlin.types.ObjectId id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.vullpes.util.model.RequestState<? extends com.vullpes.util.model.Diary>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllDiaries(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.vullpes.util.model.RequestState<java.lang.Boolean>> continuation);
}