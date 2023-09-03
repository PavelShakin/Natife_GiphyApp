package com.giphyapp.core.contracts.handlers

interface EventHandler<T> {

    fun obtainEvent(event: T)
}