package com.timife.agromall.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.timife.agromall.databinding.FragmentLoginBinding
import com.timife.agromall.enable
import com.timife.agromall.visible

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.loginprogress.visible(false)
        binding.signIn.enable(false)


        binding.editPassword.addTextChangedListener {
            val email = binding.editEmail.text.toString().trim()
            binding.signIn.enable(email.isNotEmpty() && it.toString().isNotEmpty())
        }
        binding.signIn.setOnClickListener {
            login()
        }
    }

    fun login() {
        val email = binding.editEmail
        val password = binding.editPassword
        if(email.text.toString() == "test@tellerium.io" && password.text.toString() == "password"){

        }else{
            Toast.makeText(requireContext(),"Incorrect Email or Password",Toast.LENGTH_SHORT).show()
        }
        //@todo add user validation(token)
    }
}