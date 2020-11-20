package com.colossussoftware.singleactivitywithsimplestack.ui.keys

import com.colossussoftware.singleactivitywithsimplestack.R
import com.colossussoftware.singleactivitywithsimplestack.ui.second.SecondFragment
import kotlinx.android.parcel.Parcelize

//
// Created by alican.korkmaz on 20.11.2020.
//
@Parcelize
data class SecondKey(val detailId: String) : FragmentKey() {
    override fun instantiateFragment() = SecondFragment()

    override fun getFragmentTag(): String = toString()

    override val titleRes: Int
        get() = R.string.fragment_second_title
}