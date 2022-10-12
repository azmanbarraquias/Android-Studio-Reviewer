package com.example.walkthroghreview

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2Adapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> GuideActivity("#ffffff")
                1 -> GuideActivity("#000000")
                2 -> GuideActivity("#ffffff")
                3 -> GuideActivity("#000000")
                else -> GuideActivity("#ffffff")
            }
    }

}