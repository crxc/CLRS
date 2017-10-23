package com.example.crxc.clrs

import org.junit.Test

/**
 * Created by crxc on 17-10-8.
 * Email:jdxbwsbf@gmail.com
 */
class InsertSort {
    @Test
    fun main(): Unit {
        val listOf = mutableListOf<Int>(34, 232, 54, 65, 123, 686, 8, 46, 975, 221)
        val insertSort = insertSort(listOf)
        print(insertSort)
    }

    private fun insertSort(list: MutableList<Int>): List<Int> {
        list.forEachIndexed({ index, value ->
            if (index > 0) {
                var i = index -1
                while (i >= 0 && value < list[i]) {
                    list[i + 1] = list[i]
                    i--
                }
                list[i + 1] = value
            }
        })
        return list
    }
}