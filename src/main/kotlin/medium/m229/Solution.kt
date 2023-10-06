package medium.m229

// https://leetcode.com/problems/majority-element-ii/

class Solution {

    fun majorityElement(nums: IntArray): List<Int> {
        var candidate1 = 0
        var candidate2 = 1
        var counter1 = 0
        var counter2 = 0
        for (number in nums) {
            when {
                number == candidate1 -> counter1++
                number == candidate2 -> counter2++

                counter1 == 0 -> {
                    candidate1 = number
                    counter1 = 1
                }

                counter2 == 0 -> {
                    candidate2 = number
                    counter2 = 1
                }

                else -> {
                    counter1--
                    counter2--
                }
            }
        }
        return listOf(candidate1, candidate2)
            .filter { candidate -> nums.count { candidate == it } > nums.size / 3.0 }
    }

}