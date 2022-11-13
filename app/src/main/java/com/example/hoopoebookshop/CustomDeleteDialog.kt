package com.example.hoopoebookshop

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.hoopoebookshop.databinding.DialogDeleteBinding

class CustomDeleteDialog(val context: Context, val dAtaVO: DAtaVO) {
    val dialog = Dialog(context)

    fun showDialog() {
        val binding = DialogDeleteBinding.inflate(LayoutInflater.from(context))
        dialog.setContentView(binding.root)

        dialog.window!!.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        binding.btnDeleteCancle.setOnClickListener {
            dialog.dismiss()
        }

        binding.btnDeleteOk.setOnClickListener {
            (context as MainActivity).firstFragment.refreshRecyclerviewDrop(dAtaVO)
            dialog.dismiss()
        }
    }
}