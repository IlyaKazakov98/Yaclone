package com.readyfo.yaclone.core.events

open class ErrorEvent(e: Exception): SingleEvent<Exception>(e)