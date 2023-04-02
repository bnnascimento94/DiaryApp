package com.vullpes.mongo.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J*\u0010\u0014\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00180\u00160\fj\u0002`\u00190\u0015H\u0017J2\u0010\u001a\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00180\u00160\fj\u0002`\u00190\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0017J\u001c\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\f0\u00152\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\u001f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\f2\u0006\u0010 \u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\f2\u0006\u0010 \u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/vullpes/mongo/repository/MongoDb;", "Lcom/vullpes/mongo/repository/MongoRepository;", "()V", "app", "Lio/realm/kotlin/mongodb/App;", "realm", "Lio/realm/kotlin/Realm;", "user", "Lio/realm/kotlin/mongodb/User;", "configureTheRealm", "", "deleteAllDiaries", "Lcom/vullpes/util/model/RequestState;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDiary", "Lcom/vullpes/util/model/Diary;", "id", "Lio/realm/kotlin/types/ObjectId;", "(Lio/realm/kotlin/types/ObjectId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllDiaries", "Lkotlinx/coroutines/flow/Flow;", "", "Ljava/time/LocalDate;", "", "Lcom/vullpes/mongo/repository/Diaries;", "getFilteredDiaries", "zonedDateTime", "Ljava/time/ZonedDateTime;", "getSelectedDiary", "diaryId", "insertDiary", "diary", "(Lcom/vullpes/util/model/Diary;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDiary", "mongo_debug"})
public final class MongoDb implements com.vullpes.mongo.repository.MongoRepository {
    @org.jetbrains.annotations.NotNull()
    public static final com.vullpes.mongo.repository.MongoDb INSTANCE = null;
    private static io.realm.kotlin.Realm realm;
    private static final io.realm.kotlin.mongodb.App app = null;
    private static final io.realm.kotlin.mongodb.User user = null;
    
    private MongoDb() {
        super();
    }
    
    @java.lang.Override()
    public void configureTheRealm() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"NewApi"})
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.vullpes.util.model.RequestState<java.util.Map<java.time.LocalDate, java.util.List<com.vullpes.util.model.Diary>>>> getAllDiaries() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"NewApi"})
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.vullpes.util.model.RequestState<java.util.Map<java.time.LocalDate, java.util.List<com.vullpes.util.model.Diary>>>> getFilteredDiaries(@org.jetbrains.annotations.NotNull()
    java.time.ZonedDateTime zonedDateTime) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.vullpes.util.model.RequestState<com.vullpes.util.model.Diary>> getSelectedDiary(@org.jetbrains.annotations.NotNull()
    io.realm.kotlin.types.ObjectId diaryId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object insertDiary(@org.jetbrains.annotations.NotNull()
    com.vullpes.util.model.Diary diary, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.vullpes.util.model.RequestState<? extends com.vullpes.util.model.Diary>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object updateDiary(@org.jetbrains.annotations.NotNull()
    com.vullpes.util.model.Diary diary, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.vullpes.util.model.RequestState<? extends com.vullpes.util.model.Diary>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object deleteDiary(@org.jetbrains.annotations.NotNull()
    io.realm.kotlin.types.ObjectId id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.vullpes.util.model.RequestState<? extends com.vullpes.util.model.Diary>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object deleteAllDiaries(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.vullpes.util.model.RequestState<java.lang.Boolean>> continuation) {
        return null;
    }
}