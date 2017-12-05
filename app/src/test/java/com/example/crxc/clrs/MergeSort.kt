package com.example.crxc.clrs

import org.junit.Test
import java.util.*

/**
 * Created by crxc on 17-10-23.
 * Email:jdxbwsbf@gmail.com
 */
class MergeSort {
    @Test
    fun main(): Unit {
        val listOf = mutableListOf<Int>()
        val random = Random()
        for (i in 1..10) {
            listOf.add(random.nextInt(100))
        }
        val insertSort = mergeSort(listOf, Arrow.UP)
        print(insertSort)
    }

    fun mergeSort(list: MutableList<Int>, arrow: Arrow): List<Int> {
        val listSize = list.size
        if (listSize > 1) {
            val subList = list.subList(0, listSize / 2)
            val sublist2 = list.subList(listSize / 2, listSize)
            val mergeSort = mergeSort(subList, Arrow.UP)
            val mergeSort2 = mergeSort(sublist2, Arrow.UP)
            return mergeList(mergeSort, mergeSort2, arrow)
        }
        return list
    }

    private fun mergeList(mergeSort: List<Int>, mergeSort2: List<Int>, arrow: Arrow): MutableList<Int> {
        var sortSize = 0
        var sortSize2 = 0
        val size = mergeSort.size
        val size2 = mergeSort2.size
        val mutableListOf = mutableListOf<Int>()
        while (sortSize < size && sortSize2 < size2) {
            if (arrow == Arrow.UP) {
                if (mergeSort[sortSize] < mergeSort2[sortSize2]) {
                    mutableListOf.add(mergeSort[sortSize])
                    sortSize++
                } else {
                    mutableListOf.add(mergeSort2[sortSize2])
                    sortSize2++
                }
            } else {
                if (mergeSort[sortSize] > mergeSort2[sortSize2]) {
                    mutableListOf.add(mergeSort[sortSize])
                    sortSize++
                } else {
                    mutableListOf.add(mergeSort2[sortSize2])
                    sortSize2++
                }
            }
        }
        if (sortSize == size) {
            mutableListOf.addAll(mergeSort2.subList(sortSize2, size2))
        } else {
            mutableListOf.addAll(mergeSort.subList(sortSize, size))
        }
        return mutableListOf
    }


}