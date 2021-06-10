package com.timife.agromall.dashboard

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.timife.agromall.R
import com.timife.agromall.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private lateinit var binding : FragmentDashboardBinding

    companion object {
        fun newInstance() = DashboardFragment()
    }

    private lateinit var viewModel: DashboardViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentDashboardBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        viewModel.pieChart.observe(viewLifecycleOwner) {
            binding.pieChart.data = it
            binding.pieChart.transparentCircleRadius = 0F
            binding.pieChart.setDrawEntryLabels(false)
            binding.pieChart.holeRadius = 60F
            binding.pieChart.invalidate()
        }

        binding.farmersCard.setOnClickListener {
            this.findNavController().navigate(R.id.action_dashboardFragment_to_farmersFragment)

        }


        return binding.root
    }

}