package com.hanifkf12.fragmentapplication

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    var nama=""
    var umur=""
    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        Log.d("STATE", "On Attach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("STATE", "On Create")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("STATE", "On CreateView")
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("STATE", "On Activity Created")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("STATE", "On View Created")
        btn_move.setOnClickListener {
            nama = edit_nama.text.toString()
            umur = edit_umur.text.toString()
            val bundle = Bundle()
            bundle.putString("nama" , nama)
            bundle.putString("umur" , umur)
            val profileFragment = ProfileFragment()
            profileFragment.arguments = bundle

            edit_nama.text.clear()
            edit_umur.text.clear()

            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.container_fragment, profileFragment)
                addToBackStack(null)
                commit()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("STATE", "On Start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("STATE", "On Resume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("STATE", "On Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("STATE", "On Stop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("STATE", "On Destroy View")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("STATE", "On Destroy")

    }

    override fun onDetach() {
        super.onDetach()
        Log.d("STATE", "On Detach")
    }
}
