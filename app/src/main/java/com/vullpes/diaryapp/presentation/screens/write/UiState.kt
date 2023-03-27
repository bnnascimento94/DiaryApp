package com.vullpes.diaryapp.presentation.screens.write

import com.vullpes.diaryapp.model.Diary
import com.vullpes.diaryapp.model.Mood
import io.realm.kotlin.types.RealmInstant

data class UiState(
    val selectedDiaryId: String? = null,
    val selectedDiary: Diary? = null,
    val title: String = "",
    val description: String = "",
    val mood:Mood = Mood.Neutral,
    val updatedDateTime : RealmInstant? = null
)
