package com.example.fragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragments.R
import com.example.fragments.navigate
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.fragment_dict.*

class DictFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_dict, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dict_num.text = ChatFragmentArgs.fromBundle(requireArguments()).count.toString()
        dict_but.setOnClickListener {
            navigate(DictFragmentDirections.actionDictFragmentSelf(dict_num.text.toString().toInt() + 1))
        }
    }
}