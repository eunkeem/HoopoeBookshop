package com.example.hoopoebookshop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hoopoebookshop.databinding.ItemCartBinding

class CartCustomAdapter(val cartDataList: MutableList<CartDataVO>) :
    RecyclerView.Adapter<CartCustomAdapter.CartCustomViewHolder>() {

    override fun getItemCount(): Int {
        return cartDataList.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartCustomViewHolder {
        val binding =
            ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val cartCustomViewHolder = CartCustomViewHolder(binding)
        val checkBoxItemCart = binding.checkBoxItemCart

        checkBoxItemCart.setOnCheckedChangeListener { buttonView, isChecked ->
            when (isChecked) {
                true -> checkBoxItemCart.isChecked = false
                false -> checkBoxItemCart.isChecked = true
            }
        }
        return cartCustomViewHolder
    }//viewHolder

    override fun onBindViewHolder(holder: CartCustomViewHolder, position: Int) {
        val binding = (holder as CartCustomViewHolder).binding
        val cartDataVO = cartDataList[position]
        binding.imvBookItemCart.setImageResource(cartDataVO.picture)
        binding.tvSubItemCart.text = cartDataVO.sub
        binding.tvPriceItemMain.text = cartDataVO.price
    }

    class CartCustomViewHolder(val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}
