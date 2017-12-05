package com.example.crxc.clrs

import org.junit.Test
import java.util.*

/**
 * Created by crxc on 17-10-23.
 * Email:jdxbwsbf@gmail.com
 */
class BinarySearch {
    @Test
    fun main() {
        val listOf = mutableListOf<Int>()
        val random = Random()
        for (i in 1..10) {
            listOf.add(random.nextInt(100))
        }
        val mergeSort = MergeSort().mergeSort(listOf, Arrow.UP)
        val insertSort = binarySearch(mergeSort, 50)
        print(insertSort)
        print(mergeSort)
    }

    fun binarySearch(list: List<Int>, num: Int): Int {
        var left = 0
        var right = list.lastIndex
        var mid = getMid(left, right)
        while (true) {
            if (list[mid] == num) {
                return mid
            }
            if (list[mid] > num) {
                right = mid
                mid = getMid(left, right)
            } else {
                left = mid
                mid = getMid(left, right)
            }
            if (right - left == 1) {
                return left + 2
            }
        }
    }

    fun binarySearch2(list: List<Int>, num: Int): Boolean {
        var left = 0
        var right = list.lastIndex
        var mid = getMid(left, right)
        while (true) {
            if (list[mid] == num) {
                return true
            }
            if (list[mid] > num) {
                right = mid
                mid = getMid(left, right)
            } else {
                left = mid
                mid = getMid(left, right)
            }
            if (right - left == 1) {
                if (list[right] == num) return true
                if (list[left] == num) return true
                return false
            }
        }
    }

    private fun getMid(left: Int, right: Int): Int {
        return (left + right) / 2
    }
}