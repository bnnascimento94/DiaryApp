package com.vullpes.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vullpes.util.Constants.APP_ID
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


internal class AuthenticationViewModel  constructor(): ViewModel() {

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