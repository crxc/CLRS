package com.example.crxc.clrs.Test2

import com.example.crxc.clrs.Arrow
import com.example.crxc.clrs.BinarySearch
import com.example.crxc.clrs.MergeSort
import org.junit.Test
import java.util.*

/**
 * Created by crxc on 2017/10/30.
 * Email:jdxbwsbf@gmail.com
 */
class `3-7` {
    @Test
    fun main(): Unit {
        val listOf = mutableListOf<Int>()
        val random = Random()
        for (i in 1..10) {
            listOf.add(random.nextInt(30))
        }
        val mergeSort = MergeSort().mergeSort(listOf, Arrow.UP)
        val haveNum = haveNum(20, mergeSort)
        print(haveNum)
        print(mergeSort)
    }

    private fun haveNum(i: Int, listOf: List<Int>): Boolean {
        listOf.forEach {
            val i1 = i - it
            val binarySearch = BinarySearch().binarySearch2(listOf, i1)
            if (binarySearch) return true
        }
        return false
    }
}