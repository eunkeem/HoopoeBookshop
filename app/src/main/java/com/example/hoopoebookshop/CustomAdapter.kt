package com.example.hoopoebookshop

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hoopoebookshop.databinding.ItemMainBinding

class CustomAdapter(val dataList: MutableList<DAtaVO>) :
    RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val customViewHolder = CustomViewHolder(binding)

        customViewHolder.itemView.setOnClickListener {
            val position: Int = customViewHolder.bindingAdapterPosition
            val dAtaVO = dataList.get(position)
            Toast.makeText(
                parent.context,
                "${dAtaVO.sub}, ${dAtaVO.author}, ${dAtaVO.price}",
                Toast.LENGTH_SHORT
            ).show()
        }

        customViewHolder.itemView.setOnLongClickListener{
            val position:Int =  customViewHolder.bindingAdapterPosition
            val dataVO = dataList.get(position)
//            CustomDeleteDialog(binding.root.context, dataList).showDialog()
            (parent.context as MainActivity).firstFragment.refreshRecyclerviewDrop(dataVO)
            true
        }

        return customViewHolder
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val binding = (holder as CustomViewHolder).binding
        val dataVO = dataList[position]

        binding.imvBookItemMain.setImageResource(dataVO.picture)
        binding.tvSubItemMain.text = dataVO.sub
        binding.tvPriceItemMain.text = dataVO.price
        binding.tvAuthorItemMain.text = dataVO.author
        binding.tvPublisherItemMain.text = dataVO.publisher

    }

    class CustomViewHolder(val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root){
    }
}