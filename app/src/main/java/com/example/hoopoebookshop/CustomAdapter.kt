package com.example.hoopoebookshop

import android.accounts.AccountManager.get
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hoopoebookshop.databinding.ItemMainBinding

class CustomAdapter(val dataList: MutableList<DAtaVO>, val onClickDeleteIcon:(dataVo:DAtaVO)->Unit) :RecyclerView.Adapter<CustomAdapter.CustomViewHolder>(){

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val customViewHolder = CustomViewHolder(binding)

        customViewHolder.itemView.setOnClickListener{
            val position:Int = customViewHolder.bindingAdapterPosition
            val dAtaVO = dataList.get(position)
            Toast.makeText(parent.context,"${dAtaVO.sub}, ${dAtaVO.author}, ${dAtaVO.price}", Toast.LENGTH_SHORT).show()
       }
        //롱클릭 삭제
//        customViewHolder.itemView.setOnLongClickListener{
//            val position:Int =  customViewHolder.bindingAdapterPosition
//            val dataVO = dataList.get(position)
//            (parent.context as MainActivity).firstFragment.refreshRecyclerviewDrop(dataVO)
//            true
//        }

        return customViewHolder
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
//        val listPosition = dataList[position]
//        holder.binding.dataText.text = listPosition.text
//        holder.binding.imvDeleteItemMain.setOnClickListener{
//            onClickDeleteIcon.invoke(listPosition)
//        }

    }

    class CustomViewHolder (val binding : ItemMainBinding):RecyclerView.ViewHolder(binding.root){
//        val dataText : TextView = get(){DAtaVO()}

    }

}