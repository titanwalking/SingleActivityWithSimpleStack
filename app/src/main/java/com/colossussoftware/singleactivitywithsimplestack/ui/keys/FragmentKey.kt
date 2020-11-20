package com.colossussoftware.singleactivitywithsimplestack.ui.keys

import androidx.annotation.StringRes
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentKey

//
// Created by alican.korkmaz on 20.11.2020.
//
abstract class FragmentKey : DefaultFragmentKey() {
    @get:StringRes
    abstract val titleRes: Int
}