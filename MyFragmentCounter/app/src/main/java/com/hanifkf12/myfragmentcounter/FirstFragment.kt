package com.hanifkf12.myfragmentcounter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment(){

    var count = 0
    private lateinit var firstFragmentInterface: FirstFragmentInterface
    override fun onAttach(context: Context) {
        super.onAttach(context)
        firstFragmentInterface = context as FirstFragmentInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_min_frag1.setOnClickListener {
            minSecondCount()
        }
        btn_plus_frag1.setOnClickListener {
            addSecondCount()
        }
    }
    fun addSecondCount(){
        count++
        firstFragmentInterface.showAddtoSecond(count)
    }

    fun minSecondCount(){
        count--
        firstFragmentInterface.showMintoSecond(count)
    }


    companion object {
        @JvmStatic
        fun newInstance() = FirstFragment()
    }

    fun setCountFirst(count : Int){
        tv_count_frag1.text = count.toString()
    }




}
