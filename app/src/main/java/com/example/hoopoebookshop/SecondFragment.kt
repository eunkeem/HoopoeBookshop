package com.example.hoopoebookshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hoopoebookshop.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding
    val cartDataList = mutableListOf<CartDataVO>()
    lateinit var cartCustomAdapter: CartCustomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)

        val linearLayoutManager = LinearLayoutManager(container?.context)
        val cartCustomAdapter = CartCustomAdapter(cartDataList)
        this.cartCustomAdapter = cartCustomAdapter
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.adapter = cartCustomAdapter
        return binding.root
    }
}

