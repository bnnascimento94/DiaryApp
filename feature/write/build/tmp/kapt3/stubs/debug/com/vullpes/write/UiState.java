package com.vullpes.write;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\tH\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003JK\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006$"}, d2 = {"Lcom/vullpes/write/UiState;", "", "selectedDiaryId", "", "selectedDiary", "Lcom/vullpes/util/model/Diary;", "title", "description", "mood", "Lcom/vullpes/util/model/Mood;", "updatedDateTime", "Lio/realm/kotlin/types/RealmInstant;", "(Ljava/lang/String;Lcom/vullpes/util/model/Diary;Ljava/lang/String;Ljava/lang/String;Lcom/vullpes/util/model/Mood;Lio/realm/kotlin/types/RealmInstant;)V", "getDescription", "()Ljava/lang/String;", "getMood", "()Lcom/vullpes/util/model/Mood;", "getSelectedDiary", "()Lcom/vullpes/util/model/Diary;", "getSelectedDiaryId", "getTitle", "getUpdatedDateTime", "()Lio/realm/kotlin/types/RealmInstant;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "write_debug"})
public final class UiState {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String selectedDiaryId = null;
    @org.jetbrains.annotations.Nullable()
    private final com.vullpes.util.model.Diary selectedDiary = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull()
    private final com.vullpes.util.model.Mood mood = null;
    @org.jetbrains.annotations.Nullable()
    private final io.realm.kotlin.types.RealmInstant updatedDateTime = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.vullpes.write.UiState copy(@org.jetbrains.annotations.Nullable()
    java.lang.String selectedDiaryId, @org.jetbrains.annotations.Nullable()
    com.vullpes.util.model.Diary selectedDiary, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    com.vullpes.util.model.Mood mood, @org.jetbrains.annotations.Nullable()
    io.realm.kotlin.types.RealmInstant updatedDateTime) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public UiState() {
        super();
    }
    
    public UiState(@org.jetbrains.annotations.Nullable()
    java.lang.String selectedDiaryId, @org.jetbrains.annotations.Nullable()
    com.vullpes.util.model.Diary selectedDiary, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    com.vullpes.util.model.Mood mood, @org.jetbrains.annotations.Nullable()
    io.realm.kotlin.types.RealmInstant updatedDateTime) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSelectedDiaryId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.vullpes.util.model.Diary component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.vullpes.util.model.Diary getSelectedDiary() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.vullpes.util.model.Mood component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.vullpes.util.model.Mood getMood() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final io.realm.kotlin.types.RealmInstant component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final io.realm.kotlin.types.RealmInstant getUpdatedDateTime() {
        return null;
    }
}