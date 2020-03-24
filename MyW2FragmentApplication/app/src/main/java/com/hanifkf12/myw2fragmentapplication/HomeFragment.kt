package com.hanifkf12.myw2fragmentapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var nama = "Hanif hhh"
        val bundle = Bundle()
        bundle.putString("name", nama)
        val secondFragment = SecondFragment()
        secondFragment.arguments = bundle
        button_to_second.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.container_fragment, secondFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}
