package com.example.githubmvi.mvibase

import io.reactivex.Observable
import java.util.*

interface MviView <I: MviIntent, S:MviViewState>{
    fun intents():Observable<I>
    fun render(states: S)
}