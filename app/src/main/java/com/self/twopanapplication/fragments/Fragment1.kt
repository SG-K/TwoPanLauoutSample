package com.self.twopanapplication.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.addCallback
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.self.twopanapplication.R

class Fragment1 : Fragment(R.layout.fragment_main) {

    override fun onDestroy() {
        super.onDestroy()
        Log.v("Lifecycle_track", " Fragment1 onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v("Lifecycle_track", " Fragment1 onDetach")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.v("Lifecycle_track", " Fragment1 onDestroyView")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.v("Lifecycle_track", "onViewCreated Fragment1 - ${this}")

        view.findViewById<ConstraintLayout>(R.id.cl_fragment)
            .setBackgroundColor(Color.BLACK)

        view?.findViewById<Button>(R.id.btn_1)?.setOnClickListener {
//            findNavController().navigateUp()
            requireActivity().supportFragmentManager.setFragmentResult("close", bundleOf())
        }

        requireActivity().onBackPressedDispatcher.addCallback(this@Fragment1) {
            requireActivity().supportFragmentManager.setFragmentResult("close", bundleOf())
        }

        view?.findViewById<Button>(R.id.btn_2)?.setOnClickListener {
            val rootNavHostFragment =
                requireActivity().supportFragmentManager.findFragmentById(R.id.outer_container) as NavHostFragment
            rootNavHostFragment.navController.navigate(R.id.dest_3)
        }

    }

}

class Fragment2 : Fragment(R.layout.fragment_main) {


    override fun onDestroy() {
        super.onDestroy()
        Log.v("Lifecycle_track", " Fragment2 onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v("Lifecycle_track", " Fragment2 onDetach")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.v("Lifecycle_track", " Fragment2 onDestroyView")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ConstraintLayout>(R.id.cl_fragment)
            .setBackgroundColor(Color.BLUE)

        requireActivity().onBackPressedDispatcher.addCallback(this@Fragment2) {
            requireActivity().supportFragmentManager.setFragmentResult("close", bundleOf())
        }

        view?.findViewById<Button>(R.id.btn_1)?.setOnClickListener {
//            findNavController().navigateUp()
            requireActivity().supportFragmentManager.setFragmentResult("close", bundleOf())

        }

        view?.findViewById<Button>(R.id.btn_2)?.setOnClickListener {
            val rootNavHostFragment =
                requireActivity().supportFragmentManager.findFragmentById(R.id.outer_container) as NavHostFragment
            rootNavHostFragment.navController.navigate(R.id.dest_3)
        }

    }

}

class Fragment3 : Fragment(R.layout.fragment_main) {

    override fun onDestroy() {
        super.onDestroy()
        Log.v("Lifecycle_track", " Fragment3 onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v("Lifecycle_track", " Fragment3 onDetach")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.v("Lifecycle_track", " Fragment3 onDestroyView")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val number = arguments?.getInt("num", 1) ?: 1
        val isInPan = arguments?.getBoolean("pan", false) ?: false
        view.findViewById<ConstraintLayout>(R.id.cl_fragment)
            .setBackgroundColor(Color.GREEN)

        view.findViewById<Button>(R.id.btn_1)?.text = "Back  - $number"

        view.findViewById<Button>(R.id.btn_1)?.setOnClickListener {
            val rootNavHostFragment =
                requireActivity().supportFragmentManager.findFragmentById(R.id.outer_container) as NavHostFragment
            rootNavHostFragment.navController.navigateUp()
        }

        if (isInPan){
            view.findViewById<Button>(R.id.btn_1)?.visibility = View.GONE
        }

        view.findViewById<Button>(R.id.btn_2)?.setOnClickListener {
            val rootNavHostFragment =
                requireActivity().supportFragmentManager.findFragmentById(R.id.outer_container) as NavHostFragment
            rootNavHostFragment.navController.navigate(R.id.dest_3, bundleOf("num" to if(!isInPan) (number+1) else 1 ))
        }

    }

}



class FragmentSplash : Fragment(R.layout.fragment_main) {

    override fun onDestroy() {
        super.onDestroy()
        Log.v("Lifecycle_track", " FragmentSplash onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v("Lifecycle_track", " FragmentSplash onDetach")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.v("Lifecycle_track", " FragmentSplash onDestroyView")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ConstraintLayout>(R.id.cl_fragment)
            .setBackgroundColor(Color.CYAN)

        view.findViewById<Button>(R.id.btn_1)?.text = "Pan Fragment"
        view.findViewById<Button>(R.id.btn_2)?.text = "Fragment 3 full screen"

        view.findViewById<Button>(R.id.btn_1)?.setOnClickListener {
            val rootNavHostFragment =
                requireActivity().supportFragmentManager.findFragmentById(R.id.outer_container) as NavHostFragment
            rootNavHostFragment.navController.navigate(R.id.dest_root)
        }

        view.findViewById<Button>(R.id.btn_2)?.setOnClickListener {
            val rootNavHostFragment =
                requireActivity().supportFragmentManager.findFragmentById(R.id.outer_container) as NavHostFragment
            rootNavHostFragment.navController.navigate(R.id.dest_3)
        }

    }

}

