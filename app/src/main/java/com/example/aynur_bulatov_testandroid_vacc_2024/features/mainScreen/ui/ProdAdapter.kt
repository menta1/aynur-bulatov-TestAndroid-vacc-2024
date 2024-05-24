package com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.aynur_bulatov_testandroid_vacc_2024.R
import com.example.aynur_bulatov_testandroid_vacc_2024.databinding.ProductBinding
import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel

class ProdAdapter(private val onClick: (product: ProductModel) -> Unit) :
    RecyclerView.Adapter<ProdAdapter.ProdViewHolder>() {

    private var itemList = emptyList<ProductModel>()

    fun setData(newData: List<ProductModel>) {
        val diffResult = DiffUtil.calculateDiff(ItemDiffCallback(itemList, newData))
        itemList = newData
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ProdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ProductBinding.bind(itemView)

        fun bind(productModel: ProductModel, onClick: (product: ProductModel) -> Unit) =
            with(binding) {
                name.text = productModel.name
                category.text = productModel.category
                itemView.setOnClickListener {
                    onClick(productModel)
                }
                Glide.with(itemView)
                    .load(productModel.thumbnail)
                    .centerCrop()
                    .transform(RoundedCorners(2))
                    .into(imageView2)
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product, parent, false)
        return ProdViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ProdViewHolder, position: Int) {
        holder.bind(itemList[position], onClick)
    }
}