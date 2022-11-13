package com.example.hoopoebookshop

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.hoopoebookshop.databinding.DialogCustomBinding

class CustomDialog(val context: Context, val firstFragment: FirstFragment) {
    val dialog = Dialog(context)

    fun showDialog() {
        val binding = DialogCustomBinding.inflate(LayoutInflater.from(context))
        dialog.setContentView(binding.root)
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        binding.dialogBtnCancle.setOnClickListener {
            dialog.dismiss()
        }

        binding.dialogBtnOk.setOnClickListener {
            val sub = binding.edtCustomDialogSub.text.toString()
            val price = binding.edtCustomDialogPrice.text.toString()
            val author = binding.edtCustomDialogAuthor.text.toString()
            val publisher = binding.edtCustomDialogPublisher.text.toString()
            var dataVO: DAtaVO


            dataVO = DAtaVO(R.drawable.img_book05, sub, price, author, publisher)

            (context as MainActivity).firstFragment.refreshRecyclerViewAdd(dataVO)
            dialog.dismiss()
        }
    }
}