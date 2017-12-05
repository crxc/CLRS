package com.example.crxc.clrs

import org.junit.Test
import java.util.*

/**
 * Created by crxc on 17-10-8.
 * Email:jdxbwsbf@gmail.com
 */
class InsertSort {
    @Test
    fun main(): Unit {
        val listOf = mutableListOf<Int>()
        val random = Random()
        for (i in 1..10) {
            listOf.add(random.nextInt(100))
        }
        val insertSort = insertSort2(listOf)
        print(insertSort)
    }

    private fun insertSort(list: MutableList<Int>): List<Int> {
        list.forEachIndexed({ index, value ->
            if (index > 0) {
                var i = index - 1
                while (i >= 0 && value < list[i]) {
                    list[i + 1] = list[i]
                    i--
                }
                list[i + 1] = value
            }
        })
        return list
    }

    fun insertSort2(list: MutableList<Int>): MutableList<Int> {
        if (list.size > 1) {
            val subList = list.subList(0, list.size - 1)
            val insertSort2 = insertSort2(subList)
            return insert(insertSort2, list[list.lastIndex])
        }
        return list
    }

    private fun insert(subList: MutableList<Int>, num: Int): MutableList<Int> {
        val listOf = mutableListOf<Int>()
        var b = true
        subList.forEachIndexed {
            index, i ->
            if (num > i) {
                listOf.add(i)
            } else if (b) {
                listOf.add(num)
                listOf.add(i)
                b = false
            } else {
                listOf.add(i)
            }
        }
        if(b){
            listOf.add(num)
        }
        return listOf
    }
}