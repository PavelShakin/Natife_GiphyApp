package com.giphyapp.gif.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.giphyapp.android.databinding.FragmentGifRootBinding

class GifRootFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGifRootBinding.inflate(inflater, container, false)
        return binding.root
    }
}
