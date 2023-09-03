package com.giphyapp.core.contracts.dispatchers

import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface ICoroutineDispatchers {
    val ui: CoroutineDispatcher
    val io: CoroutineDispatcher
}

class CoroutineDispatchers @Inject constructor() : ICoroutineDispatchers {
    override val ui: CoroutineDispatcher = Dispatchers.Main
    override val io: CoroutineDispatcher = Dispatchers.IO
}