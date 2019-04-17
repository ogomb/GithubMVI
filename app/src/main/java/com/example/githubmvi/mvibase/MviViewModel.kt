package com.example.githubmvi.mvibase

import io.reactivex.Observable


interface MviViewModel<I:MviIntent, S:MviViewState> {
    fun precessIntent(intents : Observable<I>)
    fun states():Observable<S>
}