package com.example.crxc.clrs

import org.junit.Test
import java.util.*

/**
 * Created by crxc on 17-10-23.
 * Email:jdxbwsbf@gmail.com
 */
class MaxChildArray {
    @Test
    fun main(): Unit {
        val listOf = mutableListOf<Int>()
        val random = Random()
        for (i in 1..10) {
            listOf.add(random.nextInt(100) - 50)
        }
        val (left, right, mutableList, sum) = maxChildArray(listOf, 0, listOf.size - 1)
        println(mutableList)
        println("left$left,right$right,sum$sum")
    }

    data class A(var left: Int, var right: Int, var mutableList: MutableList<Int>, var sum: Int)

    private fun maxChildArray(listOf: MutableList<Int>, left: Int, right: Int): A {
        if (left == right) {
            return A(left, right, listOf, listOf[left])
        }
        val mid = (left + right) / 2
        var (left1, right1, listof1, sum1) = maxChildArray(listOf, left, mid)
        val (left2, right2, listof2, sum2) = maxChildArray(listOf, mid+1, right)
        val (left3, right3, mutableList, sum) = findMaxCrossArray(listOf, left, mid, right)
        if (sum1 >= sum2 && sum1 >= sum) {
            return A(left1, right1, listof1, sum1)
        } else if (sum2 >= sum1 && sum2 >= sum) {
            return A(left2, right2, listof2, sum2)
        } else {
            return A(left3, right3, mutableList, sum)
        }
    }

    private fun findMaxCrossArray(listOf: MutableList<Int>, left: Int, mid: Int, right: Int): A {
        var sumLeft = 0
        var maxSumLeft = listOf[mid]
        var maxSumIndexLeft = mid
        var sumRight = 0
        var maxSumRight = listOf[mid]
        var maxSumIndexRight = mid
        for (i in mid downTo left) {
            sumLeft += listOf[i]
            if (sumLeft > maxSumLeft) {
                maxSumLeft = sumLeft
                maxSumIndexLeft = i
            }
        }

        for (i in mid..right) {
            sumRight += listOf[i]
            if (sumRight > maxSumRight) {
                maxSumRight = sumRight
                maxSumIndexRight = i
            }
        }
        return A(maxSumIndexLeft, maxSumIndexRight, listOf, maxSumLeft + maxSumRight - listOf[mid])
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