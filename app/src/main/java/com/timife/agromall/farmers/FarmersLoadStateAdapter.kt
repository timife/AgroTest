package com.timife.agromall.farmers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.timife.agromall.databinding.FarmersLoadStateFooterBinding

class FarmersLoadStateAdapter (private val retry: () -> Unit): LoadStateAdapter<FarmersLoadStateAdapter.LoadStateViewHolder>(){
    inner class LoadStateViewHolder(private val binding: FarmersLoadStateFooterBinding, retry: () -> Unit
    ):
        RecyclerView.ViewHolder(binding.root){

        init {
            binding.retryButton.setOnClickListener {
                retry.invoke()
            }
        }
        fun bind(loadState: LoadState){
            binding.apply {


                footerProgressBar.isVisible = loadState is LoadState.Loading
                retryButton.isVisible = loadState !is LoadState.Loading
                errorText.isVisible = loadState !is LoadState.Loading
            }
        }

    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val binding  = FarmersLoadStateFooterBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return LoadStateViewHolder(binding,retry)
    }
}