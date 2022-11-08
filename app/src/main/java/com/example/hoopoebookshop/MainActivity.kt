package com.example.hoopoebookshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.viewpager.widget.PagerAdapter
import com.example.hoopoebookshop.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var toggle:ActionBarDrawerToggle
    lateinit var binding:ActivityMainBinding
    lateinit var firstFragment: FirstFragment
    lateinit var secondFragment: SecondFragment
    lateinit var thirdFragment: ThirdFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,R.string.drawer_open, R.string.drawer_closed
        )
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()

        ////////////////////////////

        val pagerAdapter = PagerAdapter(this)
        val title = mutableListOf<String>("도서목록", "장바구니", "검색")
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()
        thirdFragment = ThirdFragment()

        pagerAdapter.addFragment(firstFragment,title[0])
        pagerAdapter.addFragment(secondFragment,title[1])
        pagerAdapter.addFragment(thirdFragment,title[2])

        binding.viewPaser.adapter = pagerAdapter






    }
}