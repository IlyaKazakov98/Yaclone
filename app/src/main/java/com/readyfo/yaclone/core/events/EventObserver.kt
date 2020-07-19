package com.readyfo.yaclone.core.events

import androidx.lifecycle.Observer

class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit): Observer<SingleEvent<T>> {
    override fun onChanged(event: SingleEvent<T>?) {
        event?.getContentIfNotHandled()?.let {
            onEventUnhandledContent(it)
        }
    }
}