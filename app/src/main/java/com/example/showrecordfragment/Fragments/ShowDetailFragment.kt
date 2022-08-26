package com.example.showrecordfragment.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.example.showrecordfragment.R

class ShowDetailFragment : Fragment() {

    private lateinit var showDetail : TextView
    private lateinit var newRecordBtn : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_show_detail, container, false)

        val name = arguments?.getString("Name")
        val age = arguments?.getString("Age")
        val city = arguments?.getString("City")

        showDetail = view.findViewById(R.id.showDetail2)

        val message = "\n$name\n$age\n$city"

        showDetail.text = message

        newRecordBtn = view.findViewById(R.id.newRecordBtn)

        newRecordBtn.setOnClickListener{
            val frag = parentFragmentManager
            val ft = frag.beginTransaction()
            ft.add(R.id.fragment_container,GetNameFragment())
            frag.popBackStack("ROOT",FragmentManager.POP_BACK_STACK_INCLUSIVE)
            ft.addToBackStack("ROOT").commit()
        }

        return view
    }
}