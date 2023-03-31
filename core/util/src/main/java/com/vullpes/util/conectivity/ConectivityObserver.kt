package com.vullpes.util.conectivity

import kotlinx.coroutines.flow.Flow

interface ConectivityObserver {

    fun observe(): Flow<Status>

    enum class Status{
        Available, Unavailable,Losing,Lost
    }

}