package com.vullpes.auth

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.stevdzasan.messagebar.ContentWithMessageBar
import com.stevdzasan.messagebar.MessageBarState
import com.stevdzasan.onetap.OneTapSignInState
import com.stevdzasan.onetap.OneTapSignInWithGoogle
import com.vullpes.util.Constants.CLIENT_ID

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun AuthenticationScreen(
    authenticated: Boolean,
    loadingState: Boolean,
    onButtonClicked: () -> Unit,
    onetapState: OneTapSignInState,
    messageBarState: MessageBarState,
    onSuccessfulFirebaseSignIn: (String) -> Unit,
    onFailedFirebaseSignIn: (Exception) -> Unit,
    onDialogDismissed: (String) -> Unit,
    navigateToHome: () -> Unit
) {

    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        ContentWithMessageBar(messageBarState = messageBarState) {
            AuthenticationContent(loadingState, onButtonClicked)
        }
    }

    OneTapSignInWithGoogle(
        state = onetapState,
        clientId = CLIENT_ID,
        onTokenIdReceived = { tokenId ->
            val credential = GoogleAuthProvider.getCredential(tokenId,null)
            FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener { task->
                    if(task.isSuccessful){
                        onSuccessfulFirebaseSignIn(tokenId)
                    }else{
                        task.exception?.let { t -> onFailedFirebaseSignIn(t) }
                    }
                }
            onSuccessfulFirebaseSignIn(tokenId)
        },
        onDialogDismissed = { message ->
            onDialogDismissed(message)
            messageBarState.addError(Exception(message))
        })

    LaunchedEffect(key1 = authenticated) {
        if (authenticated) {
            navigateToHome()
        }
    }


}