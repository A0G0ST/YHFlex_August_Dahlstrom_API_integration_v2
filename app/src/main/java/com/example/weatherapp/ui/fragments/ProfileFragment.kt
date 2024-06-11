package com.example.weatherapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.weatherapp.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usernameTextView: TextView = view.findViewById(R.id.usernameTextView)
        val passwordTextView: TextView = view.findViewById(R.id.passwordTextView)
        val hobbyTextView: TextView = view.findViewById(R.id.hobbyTextView)

        usernameTextView.text = getString(R.string.username_text)
        passwordTextView.text = getString(R.string.password_text)
        hobbyTextView.text = getString(R.string.hobby_text)
    }
}
