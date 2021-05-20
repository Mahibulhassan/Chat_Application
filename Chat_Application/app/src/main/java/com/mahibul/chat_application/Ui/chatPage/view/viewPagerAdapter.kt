package com.mahibul.chat_application.Ui.chatPage.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class viewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager) {

    private var fragments = arrayListOf<Fragment>()
    private var titels = arrayListOf<String>()

    init {
        this.fragments = arrayListOf()
        this.titels = arrayListOf()
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }
    fun addFragment (fragment: Fragment, titel : String){
        fragments.add(fragment)
        titels.add(titel)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titels.get(position)
    }
}