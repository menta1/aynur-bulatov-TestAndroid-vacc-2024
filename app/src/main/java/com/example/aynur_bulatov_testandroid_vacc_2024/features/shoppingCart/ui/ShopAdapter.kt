package com.example.aynur_bulatov_testandroid_vacc_2024.features.shoppingCart.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.aynur_bulatov_testandroid_vacc_2024.R
import com.example.aynur_bulatov_testandroid_vacc_2024.databinding.ShopItemBinding
import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel


class ShopAdapter(private val onClick: (Pair<Boolean, ProductModel>) -> Unit) :
    RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {

    private var itemList = emptyList<ProductModel>()

    fun setData(newData: List<ProductModel>) {
        val diffResult = DiffUtil.calculateDiff(ItemDiffCallback(itemList, newData))
        itemList = newData
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ShopItemBinding.bind(itemView)

        fun bind(productModel: ProductModel, onClick: (Pair<Boolean, ProductModel>) -> Unit) =
            with(binding) {
                name.text = productModel.name
                price.text = StringBuilder().append(productModel.price).append(" $")
                checkBox.setOnClickListener {
                    if (checkBox.isChecked) {
                        onClick(Pair(true, productModel))
                    } else {
                        onClick(Pair(false, productModel))
                    }
                }
                Glide.with(itemView).load(productModel.thumbnail).centerCrop()
                    .transform(RoundedCorners(2)).into(image)
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shop_item, parent, false)
        return ShopViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.bind(itemList[position], onClick)
    }
}