package com.example.showrecordfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.showrecordfragment.Fragments.GetNameFragment

class MainActivity : AppCompatActivity() {


    private lateinit var frag : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        frag = supportFragmentManager

        frag.beginTransaction().add(R.id.fragment_container,GetNameFragment()).addToBackStack("ROOT").commit()

    }
}