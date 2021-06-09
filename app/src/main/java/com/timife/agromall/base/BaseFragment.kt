package com.timife.agromall.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.timife.agromall.UserPreferences
import com.timife.agromall.ViewModelFactory
import com.timife.agromall.login.network.RetrofitClient
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


abstract class BaseFragment<VM : BaseViewModel, B : ViewBinding, Repo : BaseRepository> :
    Fragment() {

    protected lateinit var viewModel: VM
    protected lateinit var binding: B
    protected val retrofitClient = RetrofitClient()
    protected lateinit var userPreferences: UserPreferences
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        try {
            userPreferences = UserPreferences(requireContext())
            binding = getFragmentBinding(inflater, container)
            val factory = ViewModelFactory(getRepository())
            viewModel = ViewModelProvider(requireActivity(), factory).get(getViewModel())
            lifecycleScope.launch { userPreferences.authEmail.first() }
            setHasOptionsMenu(true)
        } catch (e: Exception) {
            Log.d("TAG", "onCreateView", e)
        }
        return binding.root

    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): B

    abstract fun getRepository(): Repo
}