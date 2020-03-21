package com.hanifkf12.myfragmentapplication

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
        btn_next.setOnClickListener {
            val nama = edit_nama.text.toString()
            val bundle = Bundle()
            bundle.putString("nama", nama)
            val detailFragment = DetailFragment()
            detailFragment.arguments = bundle
            edit_nama.text.clear()
            moveFragment(detailFragment)
        }
    }

    private fun moveFragment(fragment: Fragment){
        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.container_fragment,fragment)
            addToBackStack(null)
            commit()
        }
    }
}
