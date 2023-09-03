package com.giphyapp.core.views

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection

/**
 * Base screen
 */
abstract class BaseFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
}
