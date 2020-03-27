package com.hanifkf12.myfragmentcounter

interface FirstFragmentInterface{
    fun showAddtoSecond(count : Int)
    fun showMintoSecond(count : Int)

}

interface SecondFragmentInterface{
    fun showAddtoFirst(count : Int)
    fun showMintoFirst(count : Int)

}