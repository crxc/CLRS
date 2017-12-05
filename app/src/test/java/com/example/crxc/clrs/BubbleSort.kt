package com.example.crxc.clrs

import org.junit.Test
import java.util.*

/**
 * Created by crxc on 2017/10/30.
 * Email:jdxbwsbf@gmail.com
 */
class BubbleSort {
    @Test
    fun main(): Unit {
        val listOf = mutableListOf<Int>()
        val random = Random()
        for (i in 1..10) {
            listOf.add(random.nextInt(100))
        }
        val bubbleSort = bubbleSort(listOf)
        print(bubbleSort)
    }

    private fun bubbleSort(listOf: MutableList<Int>): MutableList<Int> {
        if (listOf.size < 2) return listOf
        for (i in 0 until listOf.lastIndex) {
            for (j in listOf.lastIndex downTo i + 1) {
                if (listOf[j] < listOf[j - 1]) {
                    val temp = listOf[j]
                    listOf[j] = listOf[j - 1]
                    listOf[j - 1] = temp
                }
            }
        }
        return listOf
    }
}