package com.timife.agromall.farmers


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.timife.agromall.base.BaseFragment
import com.timife.agromall.databinding.FragmentFarmersBinding
import com.timife.agromall.network.AgroMallApi

class FarmersFragment : BaseFragment<FarmersViewModel,FragmentFarmersBinding,FarmersRepository>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFarmersBinding.bind(view)
    }


    override fun getViewModel()= FarmersViewModel::class.java
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentFarmersBinding.inflate(inflater)

    override fun getRepository(): FarmersRepository {
        val api = retrofitClient.buildApi(AgroMallApi::class.java)
        return FarmersRepository(api)
    }

}