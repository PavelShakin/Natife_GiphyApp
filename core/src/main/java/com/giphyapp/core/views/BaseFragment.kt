package com.giphyapp.core.views

import android.content.Context
import androidx.fragment.app.Fragment
import com.giphyapp.core.contracts.dispatchers.ICoroutineDispatchers
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * Base screen
 */
abstract class BaseFragment : Fragment() {

    @Inject
    lateinit var coroutineDispatcher: ICoroutineDispatchers

    @Inject
    lateinit var providerFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
}
