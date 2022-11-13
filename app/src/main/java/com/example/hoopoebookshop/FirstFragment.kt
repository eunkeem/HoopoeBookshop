package com.example.hoopoebookshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hoopoebookshop.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    val dataList = mutableListOf<DAtaVO>()
    lateinit var customAdapter: CustomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        for (i in 1..4) {
            dataList.add(
                DAtaVO(
                    R.drawable.img_book_main,
                    "영화를찍으며생각한것",
                    "18000원",
                    "고레에다히로카즈",
                    "바다출판사"
                )
            )
            dataList.add(DAtaVO(R.drawable.img_book00, "인생의역사", "20000원", "신형철", "난다"))
            dataList.add(DAtaVO(R.drawable.img_book01, "투명도혼합공간", "11000원", "김리윤", "문학과지성사"))
            dataList.add(DAtaVO(R.drawable.img_book02, "도서관은살아있다", "22000원", "도서관여행자", "마티"))
            dataList.add(DAtaVO(R.drawable.img_book03, "사랑할수록지혜로워진다", "20000원", "신승철", "사우"))
            dataList.add(DAtaVO(R.drawable.img_book04, "회복력의시대", "22000원", "제러미리프킨", "민음사"))
        }
        /*리싸이클러뷰에 보여줄 레이아웃 결정*/
        val linearLayoutManager = LinearLayoutManager(container?.context)
        //리싸이클러뷰에 제공할 어뎁터
        val customAdapter = CustomAdapter(dataList)
        this.customAdapter = customAdapter


        binding.btnFloating.setOnClickListener {
//       move to Top
        }

        //리싸이클러뷰에 연결
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.adapter = customAdapter
        //데코레이션 여기서 연걸
        binding.recyclerView.addItemDecoration(Decoration(requireContext()))
        return binding.root
    }

    fun refreshRecyclerViewAdd(dataVO: DAtaVO) {
        Toast.makeText(binding.root.context, "${dataVO}", Toast.LENGTH_SHORT).show()
        dataList.add(dataVO)
        customAdapter.notifyDataSetChanged()
    }

    fun refreshRecyclerviewDrop(dataVO: DAtaVO) {
        Toast.makeText(binding.root.context, "${dataVO}", Toast.LENGTH_SHORT).show()
        dataList.remove(dataVO)
        customAdapter.notifyDataSetChanged()
    }

    fun IntentForCart(dataVO: DAtaVO) {
//        val intent = Intent(context, SecondFragment::class.java)
//        val cartDataList = arrayListOf<CartDataVO>()
//
//        intent.apply {
//            this.putExtra("picture",1)
//            this.putExtra("sub", 2)
//            this.putExtra("price", 3)
//        }
//        startActivity(intent)

//        cartDataList.add(
//            CartDataVO(
//                dataVO.picture.toInt(),
//                dataVO.sub.toString(),
//                dataVO.price.toString()
//            )
//        )
//        if(cartDataList !=null){
//            intent.putExtra("cartDataList", cartDataList)
//            startActivity(intent)
//        }else{
//            Toast.makeText(context, "cartDataList 오류", Toast.LENGTH_SHORT).show()
//        }
    }
}