package com.example.aynur_bulatov_testandroid_vacc_2024.features.account.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.aynur_bulatov_testandroid_vacc_2024.R
import com.example.aynur_bulatov_testandroid_vacc_2024.databinding.BuyItemBinding
import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel


class AccountAdapter(private val onClick: (product: ProductModel) -> Unit) :
    RecyclerView.Adapter<AccountAdapter.AccountViewHolder>() {

    private var itemList = emptyList<ProductModel>()

    fun setData(newData: List<ProductModel>) {
        val diffResult = DiffUtil.calculateDiff(ItemDiffCallback(itemList, newData))
        itemList = newData
        diffResult.dispatchUpdatesTo(this)
    }

    inner class AccountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = BuyItemBinding.bind(itemView)

        fun bind(productModel: ProductModel, onClick: (product: ProductModel) -> Unit) =
            with(binding) {
                text.text = productModel.name
                itemView.setOnClickListener {
                    onClick(productModel)
                }
                Glide.with(itemView)
                    .load(productModel.thumbnail)
                    .centerCrop()
                    .transform(RoundedCorners(2))
                    .into(image)
            }
    }

    class ItemDiffCallback(
        private val oldList: List<ProductModel>, private val newList: List<ProductModel>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.buy_item, parent, false)
        return AccountViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        holder.bind(itemList[position], onClick)
    }
}