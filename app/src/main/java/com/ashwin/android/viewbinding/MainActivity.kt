package com.ashwin.android.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ashwin.android.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.oneTextview.text = "One Text"
        binding.twoTextview.text = "Two Text"

        binding.fragmentButton.setOnClickListener {
            openFragment()
        }
    }

    private fun openFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, MainFragment.newInstance("one", "two"))
            .addToBackStack("main_fragment")
            .commit()
    }
}