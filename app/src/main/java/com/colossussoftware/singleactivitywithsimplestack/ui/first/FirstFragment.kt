package com.colossussoftware.singleactivitywithsimplestack.ui.first

import android.os.Bundle
import android.util.Log
import android.view.View
import com.colossussoftware.singleactivitywithsimplestack.R
import com.colossussoftware.singleactivitywithsimplestack.databinding.FragmentFirstBinding
import com.colossussoftware.singleactivitywithsimplestack.ui.BackHandler
import com.colossussoftware.singleactivitywithsimplestack.ui.keys.FirstKey
import com.colossussoftware.singleactivitywithsimplestack.ui.keys.SecondKey
import com.zhuinden.simplestackextensions.fragments.KeyedFragment
import com.zhuinden.simplestackextensions.fragmentsktx.backstack

class FirstFragment : KeyedFragment(R.layout.fragment_first), BackHandler {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFirstBinding.bind(view)

        with(binding) {
            goToSecondFragmentButton.setOnClickListener {
                backstack.goTo(SecondKey("testDetailId"))
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FirstFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onBackPressed(): Boolean {
        Log.d("TAG", "onBackPressed: @${getKey<FirstKey>()} ")
        return true
    }
}