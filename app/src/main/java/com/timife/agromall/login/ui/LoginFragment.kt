package com.timife.agromall.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.timife.agromall.*
import com.timife.agromall.databinding.FragmentLoginBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    private lateinit var userPreferences: UserPreferences

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        userPreferences = UserPreferences(requireContext())
        val factory = ViewModelFactory(null, userPreferences)
        viewModel = ViewModelProvider(requireActivity(), factory).get(LoginViewModel::class.java)
        lifecycleScope.launch { userPreferences.authEmail.first() }
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
        if (email.text.toString() == "test@tellerium.io" && password.text.toString() == "password") {
            saveEmail()
            requireActivity().startNewActivity(MainActivity::class.java)
        } else {
            Toast.makeText(requireContext(), "Incorrect Email or Password", Toast.LENGTH_SHORT).show()
        }
        //@todo add user validation(token)
    }

    fun saveEmail() {
        val email = binding.editEmail.toString()
        val password = binding.editPassword

//        val userPreferences = UserPreferences(requireContext())
        lifecycleScope.launch {
            viewModel.saveEmail(email)
        }
//        userPreferences.saveAuthEmail(email.text.toString())
        Toast.makeText(requireContext(), "email test save", Toast.LENGTH_SHORT).show()
    }
}