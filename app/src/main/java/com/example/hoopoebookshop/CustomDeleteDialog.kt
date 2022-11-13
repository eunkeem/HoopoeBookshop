package com.example.hoopoebookshop

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.hoopoebookshop.databinding.DialogDeleteBinding
import com.example.hoopoebookshop.databinding.FragmentFirstBinding
import com.example.hoopoebookshop.databinding.ItemMainBinding

class CustomDeleteDialog(val context: Context, val item: ItemMainBinding) {
    val dialog = Dialog(context)

    fun showDialog(){
        val binding = DialogDeleteBinding.inflate(LayoutInflater.from(context))
        dialog.setContentView(binding.root)

        dialog.window!!.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        binding.btnDeleteCancle.setOnClickListener{
            dialog.dismiss()
        }

        binding.btnDeleteOk.setOnClickListener{

        }
    }
}