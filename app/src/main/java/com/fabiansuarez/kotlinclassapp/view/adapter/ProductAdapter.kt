package com.fabiansuarez.kotlinclassapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fabiansuarez.kotlinclassapp.R
import com.fabiansuarez.kotlinclassapp.databinding.ProductItemBinding
import com.fabiansuarez.kotlinclassapp.model.entity.Product


class ProductAdapter(private var products: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    var onItemClickListener: ((Product) -> Unit)? = null
    var onItemLongClickListener: ((Product) -> Unit)? = null

    fun refresh(myProducts: ArrayList<Product>) {
        products = myProducts
        notifyDataSetChanged()
    }

    class ProductViewHolder(val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            myProduct: Product,
            onItemClickListener: ((Product) -> Unit)?,
            onItemLongClickListener: ((Product) -> Unit)?
        ) {
            binding.product = myProduct
            binding.root.setOnClickListener {
                onItemClickListener?.let {
                    it(myProduct)
                }
            }

            binding.root.setOnLongClickListener {
                onItemLongClickListener?.let {
                    it(myProduct)
                }
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val binding: ProductItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.product_item,
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products.get(position), onItemClickListener, onItemLongClickListener)
    }

    override fun getItemCount(): Int = products.size
}