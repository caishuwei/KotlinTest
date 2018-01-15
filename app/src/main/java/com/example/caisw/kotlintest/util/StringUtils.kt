package com.example.caisw.kotlintest.util

/**
 * Created by caisw on 2018/1/15.
 */
class StringUtils {

    companion object {

        fun appendSpaceAfter(str: String, length: Int = 10): String {
            var result = str
            val spaceCount = length - result.length
            if (spaceCount > 0) {
                val sb = StringBuilder().append(str)
                for (i in 1..spaceCount) {
                    sb.append(" ")
                }
                result = sb.toString()
            }
            return result
        }

    }

}