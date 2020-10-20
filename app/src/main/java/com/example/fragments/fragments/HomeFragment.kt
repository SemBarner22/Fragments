package com.example.fragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragments.R
import com.example.fragments.navigate
import kotlinx.android.synthetic.main.fragment_dict.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        navigate(HomeFragmentDirections.actionHomeFragmentToNewFragment(5))
//    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        home_num.text = ChatFragmentArgs.fromBundle(requireArguments()).count.toString()
        home_but.setOnClickListener {
            navigate(HomeFragmentDirections.actionHomeFragmentSelf(home_num.text.toString().toInt() + 1))
        }
    }
}