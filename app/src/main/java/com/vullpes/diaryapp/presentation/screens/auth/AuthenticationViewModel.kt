package com.vullpes.diaryapp.presentation.screens.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vullpes.diaryapp.util.Constants.APP_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.GoogleAuthType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(): ViewModel() {

    var authenticated by mutableStateOf(false)
    private set

    var loadingState by mutableStateOf(false)
    private set

    fun setLoading(loading:Boolean){
        loadingState = loading
    }

    fun signInWithMongoAtlas(
        tokenId:String,
        onSuccess:() -> Unit,
        onError: (Exception) -> Unit
    ){
        viewModelScope.launch {
            try{
                val result = withContext(Dispatchers.IO){
                    App.create(APP_ID).login(
                        Credentials.jwt(tokenId)
                       // Credentials.google(tokenId,GoogleAuthType.ID_TOKEN)
                    ).loggedIn
                }
                withContext(Dispatchers.Main){
                    if (result){
                        onSuccess()
                        delay(600)
                        authenticated = true
                    }else{
                        onError(Exception("User is not logged in."))
                    }
                }

            }catch (e:Exception){
                withContext(Dispatchers.Main){
                    onError(e)
                }
            }
        }
    }




}