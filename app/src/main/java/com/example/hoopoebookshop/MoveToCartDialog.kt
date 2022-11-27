package com.example.hoopoebookshop

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.hoopoebookshop.databinding.DialogDeleteBinding
import com.example.hoopoebookshop.databinding.DialogMoveToCartBinding

class MoveToCartDialog (val context: Context, val dAtaVO: DAtaVO) {
    val dialog = Dialog(context)

    fun showDialog() {
        val binding = DialogMoveToCartBinding.inflate(LayoutInflater.from(context))
        dialog.setContentView(binding.root)

        dialog.window!!.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        binding.tvCartDialog.setText(dAtaVO.sub)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        binding.btnToCartCancle.setOnClickListener {
            dialog.dismiss()
        }

        binding.btnToCartOk.setOnClickListener {
            (context as MainActivity).secondFragment.refreshRecyclerViewAdd(dAtaVO)
            dialog.dismiss()
        }
    }
}