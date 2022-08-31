package com.example.showrecordfragment.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import com.example.showrecordfragment.R

class GetNameFragment : Fragment() {

    private lateinit var inputName : EditText
    private lateinit var nameNextBtn : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_get_name, container, false)

        inputName = view.findViewById(R.id.inputName)
        nameNextBtn = view.findViewById(R.id.nameNextBtn)

        nameNextBtn.setOnClickListener {
            if(inputName.text.isEmpty()){
                inputName.error = "Enter your name"
            } else {
                val bundle = Bundle()
                bundle.putString("Name",inputName.text.toString())
                val getAge = GetAgeFragment()
                getAge.arguments = bundle
                parentFragmentManager.beginTransaction().replace(R.id.fragment_container,getAge).addToBackStack("ROOT").commit()
            }
        }
        return view
    }
}