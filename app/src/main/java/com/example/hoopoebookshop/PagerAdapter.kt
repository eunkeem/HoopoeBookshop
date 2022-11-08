package com.example.hoopoebookshop

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(activity: MainActivity):FragmentStateAdapter(activity) {
    var fragmentList = ArrayList<Fragment>()
    val titleList = ArrayList<String>()

    override fun getItemCount(): Int =fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]

    fun addFragment(fragment: Fragment, title:String){
        fragmentList.add(fragment)
        titleList.add(title)
    }
}