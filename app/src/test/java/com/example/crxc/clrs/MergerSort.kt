package com.example.crxc.clrs

import org.junit.Test

/**
 * Created by crxc on 17-10-23.
 * Email:jdxbwsbf@gmail.com
 */
class MergeSort {
    @Test
    fun main(): Unit {
        val listOf = mutableListOf<Int>(34, 232, 54, 65, 123, 686, 8, 46, 975, 221)
        val insertSort = mergeSort(listOf)
        print(insertSort)
    }

    private fun mergeSort(list: MutableList<Int>): List<Int> {
        val listSize = list.size
        if (listSize > 1) {
            val subList = list.subList(0, listSize / 2)
            val sublist2 = list.subList(listSize / 2, listSize)
            val mergeSort = mergeSort(subList)
            val mergeSort2 = mergeSort(sublist2)
            return mergeList(mergeSort, mergeSort2)
        }
        return list
    }

    private fun mergeList(mergeSort: List<Int>, mergeSort2: List<Int>): MutableList<Int> {
        var sortSize = 0
        var sortSize2 = 0
        val size = mergeSort.size
        val size2 = mergeSort2.size
        val mutableListOf = mutableListOf<Int>()
        while (sortSize < size && sortSize2 < size2) {
            if (mergeSort[sortSize] > mergeSort2[sortSize2]) {
                mutableListOf.add(mergeSort[sortSize])
                sortSize++
            } else {
                mutableListOf.add(mergeSort2[sortSize2])
                sortSize2++
            }
        }
        if (sortSize == size) {
            mutableListOf.addAll(mergeSort2.subList(sortSize2,size2))
        }else{
            mutableListOf.addAll(mergeSort.subList(sortSize,size))
        }
        return mutableListOf
    }
}