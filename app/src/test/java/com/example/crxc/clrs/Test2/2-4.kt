package com.example.crxc.clrs.Test2

import com.example.crxc.clrs.Arrow
import org.junit.Test
import java.util.*

/**
 * Created by crxc on 2017/10/31.
 * Email:jdxbwsbf@gmail.com
 */
class `2-4` {
    private var num: Int = 0
    @Test
    fun main(): Unit {
        val listOf = mutableListOf<Int>()
        val random = Random()
        for (i in 1..8) {
            listOf.add(random.nextInt(30))
        }
        val haveNum = haveNum(listOf)
        print(num)
        print(listOf)
    }

    private fun haveNum(list: MutableList<Int>): MutableList<Int> {
        val listSize = list.size
        if (listSize > 1) {
            val subList = list.subList(0, listSize / 2)
            val sublist2 = list.subList(listSize / 2, listSize)
            val mergeSort = haveNum(subList)
            val mergeSort2 = haveNum(sublist2)
            return mergeList(mergeSort, mergeSort2)
        }
        return list
    }

    private fun mergeList(mergeSort: MutableList<Int>, mergeSort2: MutableList<Int>): MutableList<Int> {
        var sortSize = 0
        var sortSize2 = 0
        val size = mergeSort.size
        val size2 = mergeSort2.size
        val mutableListOf = mutableListOf<Int>()
        while (sortSize < size && sortSize2 < size2) {
            if (mergeSort[sortSize] <= mergeSort2[sortSize2]) {
                mutableListOf.add(mergeSort[sortSize])
                sortSize++
            } else {
                num += size - sortSize
                mutableListOf.add(mergeSort2[sortSize2])
                sortSize2++
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