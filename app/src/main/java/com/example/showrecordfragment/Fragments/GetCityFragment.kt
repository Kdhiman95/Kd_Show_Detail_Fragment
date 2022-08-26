package com.example.showrecordfragment.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.showrecordfragment.R

class GetCityFragment : Fragment() {

    private lateinit var inputCity : EditText
    private lateinit var doneBtn : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_get_city, container, false)

        inputCity = view.findViewById(R.id.inputCity)
        doneBtn = view.findViewById(R.id.doneBtn)

        val name = arguments?.getString("Name")
        val age = arguments?.getString("Age")

        doneBtn.setOnClickListener {
            if(inputCity.text.isEmpty()){
                inputCity.error = "Enter your name"
            } else {
                val bundle = Bundle()
                bundle.putString("Name",name)
                bundle.putString("Age",age)
                bundle.putString("City",inputCity.text.toString())
                val showDetail = ShowDetailFragment()
                showDetail.arguments = bundle
                parentFragmentManager.beginTransaction().replace(R.id.fragment_container,showDetail).addToBackStack(null).commit()
            }
        }

        return view
    }
}