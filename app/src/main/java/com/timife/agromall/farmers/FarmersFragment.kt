package com.timife.agromall.farmers


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.paging.LoadState
import com.timife.agromall.base.BaseFragment
import com.timife.agromall.databinding.FragmentFarmersBinding
import com.timife.agromall.network.AgroMallApi
import kotlinx.android.synthetic.main.farmers_load_state_footer.*

class FarmersFragment : BaseFragment<FarmersViewModel,FragmentFarmersBinding,FarmersRepository>() {
//lateinit var viewModel: FarmersViewModel

    var swipeCount = 0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding = com.timife.agromall.databinding.FragmentFarmersBinding.bind(view)
//        viewModel =

        val adapter = FarmersAdapter(requireContext())

        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
                header = FarmersLoadStateAdapter { adapter.retry() },
                footer = FarmersLoadStateAdapter { adapter.retry() }
            )
            recyclerRetry.setOnClickListener {
                adapter.retry()
            }

            swipeRefreshFarmers.setOnRefreshListener {
                swipeCount += 1


//                if (swipeCount > 0) {
//                    bindRecyclerView(binding.categoryRecycler, data)
//                }
                viewModel.result.observe(viewLifecycleOwner, Observer{
                    adapter.submitData(viewLifecycleOwner.lifecycle, it)
                    adapter.notifyDataSetChanged()
                })

                binding.swipeRefreshFarmers.isRefreshing = false
            }
        }


        viewModel.result.observe(viewLifecycleOwner, Observer{
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
            adapter.notifyDataSetChanged()
        })


        adapter.addLoadStateListener { loadState ->
            binding.apply {
                farmersProgress.isVisible = loadState.refresh is LoadState.Loading
                recyclerView.isVisible = loadState.refresh is LoadState.NotLoading
                recyclerRetry.isVisible = loadState.refresh is LoadState.Error
                queryNoResultText.isVisible = loadState.refresh is LoadState.Error

            }
        }
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