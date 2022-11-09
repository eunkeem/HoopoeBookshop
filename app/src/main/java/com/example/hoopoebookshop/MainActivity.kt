package com.example.hoopoebookshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.viewpager.widget.PagerAdapter
import com.example.hoopoebookshop.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var binding: ActivityMainBinding
    lateinit var firstFragment: FirstFragment
    lateinit var secondFragment: SecondFragment
    lateinit var thirdFragment: ThirdFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout, R.string.drawer_open, R.string.drawer_closed
        )
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()

        ////////////////////////////

        val pagerAdapter = PagerAdapter(this)
        val title = mutableListOf<String>("도서목록", "장바구니", "검색")
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()
        thirdFragment = ThirdFragment()

        pagerAdapter.addFragment(firstFragment, title[0])
        pagerAdapter.addFragment(secondFragment, title[1])
        pagerAdapter.addFragment(thirdFragment, title[2])

       binding.viewPaser.adapter = pagerAdapter
//        TabLayoutMediator(binding.tablayout, binding.viewPaser) { tab, position ->
//            tab.text = title.get(position)
//        }.attach()

//        binding.extendFloatingActionButton.shrink()
//        binding.extendFloatingActionButton.setOnClickListener {
//            when (binding.extendFloatingActionButton.isExtended) {
//                true -> binding.extendFloatingActionButton.shrink()
//                false -> binding.extendFloatingActionButton.extend()
//            }
//            Toast.makeText(applicationContext, "extend tab click", Toast.LENGTH_SHORT).show()
//        }
//        binding.navigationview.setNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.item_info -> {
//                    Toast.makeText(applicationContext, "베스트셀러", Toast.LENGTH_SHORT).show()
//                }
//                R.id.item_report -> {
//                    Toast.makeText(applicationContext, "관심도서", Toast.LENGTH_SHORT).show()
//                }
//                R.id.item_add -> {
//                    Toast.makeText(applicationContext, "장바구니", Toast.LENGTH_SHORT).show()
//                }
//            }
//            true
//        }
//    }
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.navi_menu, menu)
//
//        val menuItem = menu?.findItem(R.id.menu_search)
//        val searchView = menuItem?.actionView as SearchView
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(searchText: String?): Boolean {
//                Log.d("AppbarProject", "${searchText}")
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                return true
//            }
//        })
//        return super.onCreateOptionsMenu(menu)
//    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (toggle.onOptionsItemSelected(item)) {
//            return true
//        }
//        when (item.itemId) {
//            R.id.menu_save -> {
//                Toast.makeText(applicationContext, "save", Toast.LENGTH_SHORT).show()
//            }
//            R.id.menu_search -> {
//                Toast.makeText(applicationContext, "search", Toast.LENGTH_SHORT).show()
//            }
//            R.id.menu_load -> {
//                Toast.makeText(applicationContext, "load", Toast.LENGTH_SHORT).show()
//            }
//            R.id.menu_open -> {
//                Toast.makeText(applicationContext, "open", Toast.LENGTH_SHORT).show()
//            }
//        }
//        return super.onOptionsItemSelected(item)
    }
}