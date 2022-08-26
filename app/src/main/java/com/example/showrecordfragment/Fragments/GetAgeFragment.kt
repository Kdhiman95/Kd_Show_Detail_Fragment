package com.example.showrecordfragment.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.showrecordfragment.R

class GetAgeFragment : Fragment() {

    private lateinit var inputAge : EditText
    private lateinit var ageNextBtn : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_get_age, container, false)

        inputAge = view.findViewById(R.id.inputAge)
        ageNextBtn = view.findViewById(R.id.ageNextBtn)

        ageNextBtn.setOnClickListener {
            if(inputAge.text.isEmpty()){
                inputAge.error = "Enter your name"
            } else {
                val name = arguments?.getString("Name")
                val bundle = Bundle()
                bundle.putString("Name",name)
                bundle.putString("Age",inputAge.text.toString())
                val getCity = GetCityFragment()
                getCity.arguments = bundle
                parentFragmentManager.beginTransaction().replace(R.id.fragment_container,getCity).addToBackStack(null).commit()
            }
        }

        return view
    }
}