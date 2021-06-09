package com.timife.agromall.farmers

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.timife.agromall.databinding.FarmerCardItemBinding
import com.timife.agromall.response.Farmer

class FarmersAdapter(
    private val context: Context,
    private val onClickListener: OnClickListener
) : PagingDataAdapter<Farmer, FarmersAdapter.FarmerViewHolder>(FARMER_COMPARATOR) {
    inner class FarmerViewHolder(private var binding: FarmerCardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(farmerItem: Farmer) {

            binding.farmers = farmerItem
            binding.executePendingBindings()
        }
    }

    companion object {
        private val FARMER_COMPARATOR = object : DiffUtil.ItemCallback<Farmer>() {
            override fun areItemsTheSame(oldItem: Farmer, newItem: Farmer) =
                oldItem.farmer_id == newItem.farmer_id

            override fun areContentsTheSame(oldItem: Farmer, newItem: Farmer) =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmerViewHolder {
        return FarmerViewHolder(
            FarmerCardItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FarmerViewHolder, position: Int) {
        val farmerItem = getItem(position)

        if (farmerItem != null) {
            holder.bind(farmerItem)
        }
        holder.itemView.setOnClickListener {
            if (farmerItem != null) {
                onClickListener.onClick(farmerItem)
            }
        }
//        holder.itemView.dropdown.setOnClickListener {
//            val inventoryItemOptions = arrayOf("Delete")
//            MaterialAlertDialogBuilder(context).setTitle("")
//                .setItems(inventoryItemOptions) { dialog,
//                                                  which ->
//                    MaterialAlertDialogBuilder(context).setTitle("Delete Item").setMessage("Do you want to completely delete this classification?").setNegativeButton("No"){
//                            dialog, _ ->
//                        dialog.dismiss()
//                    }.setPositiveButton("Yes"){
//                            dialog, _ ->
//                        onDeleteListener.delete(inventoryProduct!!)
//                        notifyDataSetChanged()
//                        dialog.dismiss()
//                    }.show()
//                }.show()
//        }
    }

    class OnClickListener(val clickListener: (product: Farmer) -> Unit) {
        fun onClick(item: Farmer) {
            clickListener(item)
        }
    }

//
//    class OnDeleteListener(val deleteListener: (Int) -> Unit) {
//        fun delete(product: Inventory) {
//            deleteListener(product.id)
//        }
//    }


}
