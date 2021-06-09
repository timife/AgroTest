package com.timife.agromall.farmers

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.timife.agromall.R
import com.timife.agromall.base.BaseFragment
import com.timife.agromall.databinding.FragmentFarmersBinding

class FarmersFragment : BaseFragment<FarmersViewModel,FragmentFarmersBinding,FarmersRepository>() {

    companion object {
        fun newInstance() = FarmersFragment()
    }

    override fun getViewModel()= FarmersViewModel::class.java
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentFarmersBinding.inflate(inflater)

    override fun getRepository(): FarmersRepository {
        val api = retrofitClient.buildApi(InventoryApi::class.java)

    }

//    private lateinit var viewModel: FarmersViewModel

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.fragment_farmers, container, false)
//    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(FarmersViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

}