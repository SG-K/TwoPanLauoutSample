package com.self.twopanapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.outer_container) as NavHostFragment
        val navController = navHostFragment.navController
        val graph = navController.navInflater.inflate(R.navigation.root_nav_graph)
        navController.setGraph(graph, Bundle())


    }
}