package com.vullpes.diaryapp.presentation.screens.write

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.clock.ClockDialog
import com.maxkeppeler.sheets.clock.models.ClockSelection
import com.vullpes.diaryapp.model.Diary
import com.vullpes.diaryapp.presentation.components.CustomAlertDialog
import com.vullpes.diaryapp.util.UtilFunctions.toInstant
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WriteTopBar(
    selectedDiary: Diary?,
    moodName: () -> String,
    onDateTimeUpdated: (ZonedDateTime) -> Unit,
    onDeleteConfirmed: () -> Unit,
    onBackPressed: () -> Unit
) {
    val dateDialog = rememberSheetState()
    val timeDialog = rememberSheetState()
    var currentdate by remember { mutableStateOf(LocalDate.now())}
    var currentTime by remember{ mutableStateOf(LocalTime.now())}
    val formattedDate = remember(key1 = currentdate) {
        DateTimeFormatter
            .ofPattern("dd MMM yyyy")
            .format(currentdate).uppercase()
    }
    val formattedTime = remember(key1 = currentTime){
        DateTimeFormatter
            .ofPattern("hh:mm a")
            .format(currentTime).uppercase()
    }
    var dateTimeUpdated by remember{ mutableStateOf(false) }
    val selectedDiaryDateTime = remember(selectedDiary){
        if(selectedDiary != null){
            SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())
                .format(Date.from(selectedDiary?.date?.toInstant())).uppercase()
        }else{
            "$formattedDate, $formattedTime"
        }
    }
    CenterAlignedTopAppBar(
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back Arrow Icon"
                )
            }
        },
        title = {
            Column {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = moodName(),
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = if(selectedDiary != null && dateTimeUpdated) "$formattedDate, $formattedTime"
                    else if(selectedDiary != null) selectedDiaryDateTime
                    else "$formattedDate, $formattedTime",
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    ),
                    textAlign = TextAlign.Center
                )
            }
        },
        actions = {
            if(dateTimeUpdated){
                IconButton(onClick = {
                    currentdate = LocalDate.now()
                    currentTime = LocalTime.now()
                    dateTimeUpdated = false
                    onDateTimeUpdated(
                        ZonedDateTime.of(
                            currentdate,
                            currentTime,
                            ZoneId.systemDefault()
                        )
                    )
                }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Icon",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }else{
                IconButton(onClick = {
                    dateDialog.show()
                }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Date Icon",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }


            if (selectedDiary != null) {
                DeleteDiaryAction(onDeleteConfirmed = onDeleteConfirmed, selectedDiary = selectedDiary)
            }

        }
    )

    CalendarDialog(
        state = dateDialog,
        selection = CalendarSelection.Date{localDate ->
            currentdate = localDate
            timeDialog.show()
        },
        config = CalendarConfig(monthSelection = true, yearSelection = true)
    )

    ClockDialog(
        state = timeDialog,
        selection = ClockSelection.HoursMinutes{ hours, minutes ->
            currentTime = LocalTime.of(hours,minutes)
            dateTimeUpdated = true
            onDateTimeUpdated(
                ZonedDateTime.of(
                    currentdate,
                    currentTime,
                    ZoneId.systemDefault()
                )
            )
        }
    )

}



@Composable
fun DeleteDiaryAction(
    selectedDiary: Diary?,
    onDeleteConfirmed: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var openDialog by remember { mutableStateOf(false) }
    DropdownMenu(expanded = expanded,
        onDismissRequest = { expanded = false }) {
        DropdownMenuItem(
            text = {
                   Text(text = "Delete")
            },
            onClick = {
                openDialog = true
                expanded = false
            }
        )
    }

    CustomAlertDialog(
        title = "Delete",
        message = "Are you sure you want to permanently delete this diary note ${selectedDiary?.title}?",
        dialogOpened = openDialog,
        onCloseDialog = {openDialog = false},
        onYesClicked = onDeleteConfirmed
    )
    IconButton(onClick = {expanded = !expanded}){
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "OverFlowMenuIcon",
            tint = MaterialTheme.colorScheme.onSurface
        )
    }

}