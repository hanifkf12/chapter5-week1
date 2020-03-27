package com.hanifkf12.myfragmentcounter

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_second.view.*

class SecondFragment : Fragment(){
    companion object {
        @JvmStatic
        fun newInstance() = SecondFragment()
    }
    var count2 = 0
    private lateinit var secondFragmentInterface: SecondFragmentInterface
    lateinit var textCount : TextView
    override fun onAttach(context: Context) {
        super.onAttach(context)
        secondFragmentInterface = context as SecondFragmentInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        textCount = view.tv_second
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_plus_frag2.setOnClickListener {
            count2++
            secondFragmentInterface.showAddtoFirst(count2)
        }
        btn_min_frag2.setOnClickListener {
            count2--
            secondFragmentInterface.showMintoFirst(count2)
        }

    }
    fun setCount(count : Int){
        Log.d("COUNT 2", count.toString())
        textCount.text = count.toString()
    }






}
