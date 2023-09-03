package com.giphyapp.core.views

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.giphyapp.core.contracts.dispatchers.ICoroutineDispatchers
import com.giphyapp.core.navigation.NavCommand
import com.giphyapp.core.navigation.navigate
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

    protected fun navigateToDeepLink(uri: Uri) {
        navigate(NavCommand(uri = uri))
    }

    protected fun navigateToAction(
        action: Int,
        bundle: Bundle? = null
    ) {
        findNavController().navigate(action, bundle)
    }
}
