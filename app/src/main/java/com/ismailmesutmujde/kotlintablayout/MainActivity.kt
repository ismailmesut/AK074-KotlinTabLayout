package com.ismailmesutmujde.kotlintablayout

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.ismailmesutmujde.kotlintablayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain : ActivityMainBinding

    private val fragmentList = ArrayList<Fragment>()
    private val fragmentTitleList = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingMain.root
        setContentView(view)

        fragmentList.add(FirstFragment())
        fragmentList.add(SecondFragment())
        fragmentList.add(ThirdFragment())

        val adapter = MyViewPagerAdapter(this)
        bindingMain.viewPager2.adapter = adapter

        fragmentTitleList.add("BIKE")
        fragmentTitleList.add("CAR")
        fragmentTitleList.add("BUS")

        TabLayoutMediator(bindingMain.tabLayout, bindingMain.viewPager2) { tab, position ->
            tab.setText(fragmentTitleList[position])
        }.attach()

        bindingMain.tabLayout.getTabAt(0)!!.setIcon(R.drawable.bike_image)
        bindingMain.tabLayout.getTabAt(1)!!.setIcon(R.drawable.car_image)
        bindingMain.tabLayout.getTabAt(2)!!.setIcon(R.drawable.bus_image)
    }

    inner class MyViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }

    }
}