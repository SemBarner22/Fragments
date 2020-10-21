package com.example.fragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragments.R
import com.example.fragments.navigate
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.fragment_new.*

class ChatFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)
//        numb.text = "wfewwf"
//
        return view
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        numb.text = ChatFragmentArgs.fromBundle(requireArguments()).count.toString()
        chat_but.setOnClickListener {
            navigate(ChatFragmentDirections.actionChatFragmentSelf(numb.text.toString().toInt() + 1))
        }
    }
}