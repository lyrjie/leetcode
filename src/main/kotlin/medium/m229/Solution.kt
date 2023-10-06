package medium.m229

// https://leetcode.com/problems/majority-element-ii/

class Solution {

    fun majorityElement(nums: IntArray): List<Int> {
        // Sorting array in place to have O(1) space. In production code this method would have been kept pure
        nums.sort()
        val majorityMinCount = nums.size / 3.0
        val result = mutableListOf<Int>()

        var currentNumber = nums[0]
        var currentNumberCounter = 1
        for (index in 1..nums.lastIndex) {
            if (nums[index] == currentNumber) {
                currentNumberCounter++
            } else {
                if (currentNumberCounter > majorityMinCount) result.add(currentNumber)
                currentNumber = nums[index]
                currentNumberCounter = 1
            }
        }
        if (currentNumberCounter > majorityMinCount) result.add(currentNumber)
        return result
    }

}