package medium.m343

import kotlin.math.pow

// https://leetcode.com/problems/integer-break/

class Solution {

    fun integerBreak(n: Int): Int {
        require(n in 2..58)
        return when {
            n <= 3 -> n - 1
            n % 3 == 0 -> 3.0.pow(n / 3).toInt()
            n % 3 == 1 -> 3.0.pow(n / 3 - 1).toInt() * 4
            else -> 3.0.pow(n / 3).toInt() * 2
        }
    }

}