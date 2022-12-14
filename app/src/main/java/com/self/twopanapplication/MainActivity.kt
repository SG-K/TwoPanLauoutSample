package com.self.twopanapplication

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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


        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels

        Log.v("screen_sizesss", "width - $width")
        Log.v("screen_sizesss", "height - $height")


    }
}



fun printGiveRow( row : Int ){
    val array = ArrayList<String>()
    array.add("1")
    array.add("11")
    for( i in 1..row){
        // for( i = 1; i <= row; i++){
        val data : CharArray = array[i].toCharArray()
        var nextRow : String = ""
        data.forEachIndexed{ index, char ->
            val digit = char.toString().toInt()
            if(index == 0){
                nextRow = digit.toString()
            } else if (index == data.size-1){
                nextRow = "$nextRow$digit"
            } else {
                val tenp = digit + data[index+1].toString().toInt()
                nextRow = "$nextRow$tenp"
            }
        }
        array.add(nextRow)
    }
    println("size = ${array[row]}")
    println(array[row])
}



fun printGiveRow2( row : Int ){
    val array = ArrayList<String>()
    array.add("1")
    array.add("11")
    for( i in 1..row){
        // for( i = 1; i <= row; i++){
        val data : CharArray = array[i].toCharArray()
        var nextRow : String = ""
        data.forEachIndexed{ index, char ->
            val digit = char.toString().toInt()
            if(index == 0){
                nextRow = digit.toString()
                // } else if (index == data.size-1){
                //     nextRow = "$nextRow$digit"

                // } else {
                //     val tenp : Int = digit + data[index+1].toString().toInt()
                //     nextRow = "$nextRow$tenp"
                // }
            } else {
                val tenp : Int =  data[index-1].toString().toInt() + digit
                nextRow = "$nextRow$tenp"
                if (index == data.size-1){
                    nextRow = "$nextRow$digit"
                }
            }
        }
        array.add(nextRow)
    }
    println("size = ${array[row]}")
    println(array[row])
}





fun getMaxPasses(array : List<Int>){
    var maxPasses = 0
    var largestNumber = 0
    println("array size  = ${array.size}")
    array.forEachIndexed{ index, value->

        if(largestNumber > array.size){
            println("Min Passes Required 1 : $maxPasses")
            return
        }

        if(value == 1){
            if(index != array.size -1){
                maxPasses++
                largestNumber = array[index+1]
            } else {
                println("Min Passes Required 2 : $maxPasses")
                return
            }
        } else {



            if(index != 0 && largestNumber != array[index]){
                println("Index1 = $index")
                println("value = $value")
                if(index+value <= array.size -1){
                    for(index2 in index..(index+value)){
                        if(largestNumber < array[index2]){
                            largestNumber = array[index2]
                        }
                    }
                    println("largestNumber = $largestNumber")
                    println("")
                    maxPasses++

                }else {
                    println("Min Passes Required 3 : $maxPasses")
                    return
                }
            } else if(index == 0){
                maxPasses++
            }



        }

    }
}