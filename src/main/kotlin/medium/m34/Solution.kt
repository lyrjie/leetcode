package medium.m34

class Solution {

    fun searchRange(nums: IntArray, target: Int): IntArray {
        val start = nums.indexOfFirst { it == target }
        val end = nums.indexOfLast { it == target }
        return intArrayOf(start, end)
    }

}