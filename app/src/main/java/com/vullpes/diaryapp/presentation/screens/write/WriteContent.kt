package com.vullpes.diaryapp.presentation.screens.write

import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.vullpes.diaryapp.model.Diary
import com.vullpes.diaryapp.model.GalleryImage
import com.vullpes.diaryapp.model.GalleryState
import com.vullpes.diaryapp.model.Mood
import com.vullpes.diaryapp.presentation.components.GalleryUploader
import io.realm.kotlin.ext.toRealmList
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun WriteContent(
    uiState: UiState,
    paddingValues: PaddingValues,
    pagerState: PagerState,
    title: String,
    onTitleChanged: (String) -> Unit,
    description: String,
    onDescriptionChanged: (String) -> Unit,
    onSaveClicked: (Diary) -> Unit,
    galleryState: GalleryState,
    onImageSelect:(Uri) ->Unit,
    onImageClicked: (GalleryImage) -> Unit
) {
    val scroollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    LaunchedEffect(key1 = scroollState.maxValue){
        scroollState.scrollTo(scroollState.maxValue)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
            .navigationBarsPadding()
            .padding(top = paddingValues.calculateTopPadding())
            .padding(bottom = 24.dp)
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(scroollState)
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            HorizontalPager(count = Mood.values().size, state = pagerState) { page ->
                AsyncImage(
                    modifier = Modifier.size(120.dp),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(Mood.values()[page].icon)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Mood Image"

                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.title,
                onValueChange = onTitleChanged,
                placeholder = {
                    Text(text = "Title")
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Unspecified,
                    disabledIndicatorColor = Color.Unspecified,
                    unfocusedIndicatorColor = Color.Unspecified,
                    placeholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                ),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    scope.launch {
                        scroollState.animateScrollTo(Int.MAX_VALUE)
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                }),
                maxLines = 1,
                singleLine = true

            )

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.description,
                onValueChange = onDescriptionChanged,
                placeholder = {
                    Text(text = "Tell me about it")
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Unspecified,
                    disabledIndicatorColor = Color.Unspecified,
                    unfocusedIndicatorColor = Color.Unspecified,
                    placeholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                ),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {focusManager.clearFocus()}),

            )

        }
        Column(verticalArrangement = Arrangement.Bottom) {
            Spacer(modifier = Modifier.height(12.dp))
            GalleryUploader(
                galleryState = galleryState,
                onAddClicked = { focusManager.clearFocus()},
                onImageSelect = onImageSelect,
                onImageClicked = onImageClicked
            )
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                onClick = {
                    if(uiState.title.isNotEmpty() && uiState.description.isNotEmpty()){
                        onSaveClicked(Diary().apply{
                            this.title = uiState.title
                            this.description = uiState.description
                            this.date
                            this.images = galleryState.images.map { it.remoteImagePath }.toRealmList()
                        })
                    }else {
                        scope.launch {
                            Toast.makeText(
                                context,
                                "Fields cannot be empty",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                },
                shape = Shapes().small
            ){
                Text(text = "Save")
            }
        }
    }

}