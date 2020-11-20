package com.colossussoftware.singleactivitywithsimplestack.ui.keys

import com.colossussoftware.singleactivitywithsimplestack.R
import com.colossussoftware.singleactivitywithsimplestack.ui.first.FirstFragment
import kotlinx.android.parcel.Parcelize


//
// Created by alican.korkmaz on 20.11.2020.
//
@Parcelize
class FirstKey : FragmentKey() {
    override fun instantiateFragment() = FirstFragment.newInstance()

    override val titleRes: Int
        get() = R.string.fragment_first_title
}