package com.self.twopanapplication.fragments

import android.graphics.Color
import android.os.Bundle
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

    }

}

class Fragment3 : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ConstraintLayout>(R.id.cl_fragment)
            .setBackgroundColor(Color.GREEN)

        view?.findViewById<Button>(R.id.btn_1)?.setOnClickListener {
            val rootNavHostFragment =
                requireActivity().supportFragmentManager.findFragmentById(R.id.outer_container) as NavHostFragment
            rootNavHostFragment.navController.navigateUp()
        }

    }

}

