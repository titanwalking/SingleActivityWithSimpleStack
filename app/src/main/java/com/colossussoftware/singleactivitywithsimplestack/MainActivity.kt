package com.colossussoftware.singleactivitywithsimplestack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.colossussoftware.singleactivitywithsimplestack.databinding.ActivityMainBinding
import com.colossussoftware.singleactivitywithsimplestack.ui.BackHandler
import com.colossussoftware.singleactivitywithsimplestack.ui.keys.FirstKey
import com.colossussoftware.singleactivitywithsimplestack.ui.keys.FragmentKey
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.SimpleStateChanger
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.navigator.Navigator
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentKey
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentStateChanger
import com.zhuinden.simplestackextensions.navigatorktx.backstack

class MainActivity : AppCompatActivity(), SimpleStateChanger.NavigationHandler {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentStateChanger: DefaultFragmentStateChanger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentStateChanger = DefaultFragmentStateChanger(supportFragmentManager, R.id.container)

        Navigator.configure()
                .setStateChanger(SimpleStateChanger(this))
                .install(this, binding.container, History.of(FirstKey()))
    }

    override fun onBackPressed() {
        val topKey = backstack.top<DefaultFragmentKey>()

        val fragment = supportFragmentManager.findFragmentByTag(topKey.fragmentTag)

        if (fragment is BackHandler) {
            val handled = fragment.onBackPressed()
            if (handled) {
                return
            }
        }

        super.onBackPressed()
    }

    override fun onNavigationEvent(stateChange: StateChange) {
        val newKey = stateChange.topNewKey<FragmentKey>()

        binding.toolbar.setTitle(newKey.titleRes)

        fragmentStateChanger.handleStateChange(stateChange)
    }
}