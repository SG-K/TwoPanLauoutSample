package com.self.twopanapplication.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.self.twopanapplication.R
import com.self.twopanapplication.utils.TwoPaneOnBackPressedCallback

class FragmentRoot : Fragment(R.layout.fragment_root) {

    lateinit var navHostFragment : NavHostFragment
    lateinit var slidingPaneLayout: SlidingPaneLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        slidingPaneLayout = view.findViewById<SlidingPaneLayout>(R.id.slidingpanle)
        navHostFragment =
            childFragmentManager.findFragmentById(R.id.inner_container) as NavHostFragment
        val navController = navHostFragment.navController
        val graph = navController.navInflater.inflate(R.navigation.inner)
        navController.setGraph(graph, Bundle())

        setWidths()

        clicklistenrer()
    }

    private fun setWidths() {

//        view?.findViewById<ConstraintLayout>(R.id.cl_left)?.layoutParams?.width = 600
//        view?.findViewById<View>(R.id.inner_container)?.layoutParams?.width = 1450
//        view?.findViewById<ConstraintLayout>(R.id.cl_left)?.minimumWidth = 432
//        view?.findViewById<View>(R.id.inner_container)?.minimumWidth = 852

//        view?.findViewById<ConstraintLayout>(R.id.cl_left)?.minimumWidth = 600
//        view?.findViewById<View>(R.id.inner_container)?.minimumWidth = 1450

    }

    private fun clicklistenrer() {

//        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
//            TwoPaneOnBackPressedCallback(slidingPaneLayout))

        requireActivity().supportFragmentManager.setFragmentResultListener("close", viewLifecycleOwner) { requestKey, bundle ->
            slidingPaneLayout.closePane()
        }


        view?.findViewById<Button>(R.id.btn_1)?.setOnClickListener {
            val navController = navHostFragment.navController
            navController.navigate(
                // Assume the itemId is the android:id of a destination in
                // the graph.
                R.id.dest_1,
                null,
                NavOptions.Builder()
                    // Pop all destinations off the back stack.
                    .setPopUpTo(navController.graph.startDestinationId, true)
                    .apply {
                        // If we're already open and the detail pane is visible,
                        // crossfade between the destinations.
//                        if (slidingPaneLayout.isOpen) {
//                            setEnterAnim(R.animator.nav_default_enter_anim)
//                            setExitAnim(R.animator.nav_default_exit_anim)
//                        }
                    }
                    .build()
            )
            slidingPaneLayout.open()
        }

        view?.findViewById<Button>(R.id.btn_2)?.setOnClickListener {
            val navController = navHostFragment.navController
            navController.navigate(
                // Assume the itemId is the android:id of a destination in
                // the graph.
                R.id.dest_2,
                null,
                NavOptions.Builder()
                    // Pop all destinations off the back stack.
                    .setPopUpTo(navController.graph.startDestinationId, true)
                    .apply {
                        // If we're already open and the detail pane is visible,
                        // crossfade between the destinations.
//                        if (slidingPaneLayout.isOpen) {
//                            setEnterAnim(R.animator.nav_default_enter_anim)
//                            setExitAnim(R.animator.nav_default_exit_anim)
//                        }
                    }
                    .build()
            )
            slidingPaneLayout.open()

//            view?.findViewById<ConstraintLayout>(R.id.cl_left)?.layoutParams?.width = 200
//            view?.findViewById<View>(R.id.inner_container)?.visibility = View.VISIBLE
//            slidingPaneLayout.open()

        }


        view?.findViewById<Button>(R.id.btn_3)?.setOnClickListener {
//            val rootNavHostFragment =
//                requireActivity().supportFragmentManager.findFragmentById(R.id.outer_container) as NavHostFragment
//            rootNavHostFragment.navController.navigate(R.id.dest_3)

            val navController = navHostFragment.navController
            navController.navigate(
                // Assume the itemId is the android:id of a destination in
                // the graph.
                R.id.dest_3,
                bundleOf("pan" to true),
                NavOptions.Builder()
                    // Pop all destinations off the back stack.
                    .setPopUpTo(navController.graph.startDestinationId, true)
                    .apply {
                        // If we're already open and the detail pane is visible,
                        // crossfade between the destinations.
//                        if (slidingPaneLayout.isOpen) {
//                            setEnterAnim(R.animator.nav_default_enter_anim)
//                            setExitAnim(R.animator.nav_default_exit_anim)
//                        }
                    }
                    .build()
            )
            slidingPaneLayout.open()
        }

        view?.findViewById<Button>(R.id.btn_4)?.setOnClickListener {
            val rootNavHostFragment =
                requireActivity().supportFragmentManager.findFragmentById(R.id.outer_container) as NavHostFragment
            rootNavHostFragment.navController.navigateUp()
        }


    }

}