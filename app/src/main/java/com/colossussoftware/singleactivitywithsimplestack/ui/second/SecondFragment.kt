package com.colossussoftware.singleactivitywithsimplestack.ui.second

import android.os.Bundle
import android.view.View
import com.colossussoftware.singleactivitywithsimplestack.R
import com.colossussoftware.singleactivitywithsimplestack.databinding.FragmentSecondBinding
import com.colossussoftware.singleactivitywithsimplestack.ui.first.FirstFragment
import com.colossussoftware.singleactivitywithsimplestack.ui.keys.SecondKey
import com.zhuinden.simplestackextensions.fragments.KeyedFragment
import com.zhuinden.simplestackextensions.fragmentsktx.backstack

class SecondFragment : KeyedFragment(R.layout.fragment_second) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSecondBinding.bind(view)

        with(binding) {
            passedDataText = "Passed Detail ID: ${getKey<SecondKey>().detailId}"

            returnToPreviousScreen.setOnClickListener {
                backstack.goBack()
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
}