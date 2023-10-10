package hard.h2009

import kotlin.math.min

class Solution {

    fun minOperations(nums: IntArray): Int {
        val sortedUniqueNums = nums.toSet().sorted()

        var bestOperationCount = Int.MAX_VALUE
        var maxValueIndex = 0
        for (minValueIndex in sortedUniqueNums.indices) {
            val minValue = sortedUniqueNums[minValueIndex]
            val maxValue = minValue + nums.size - 1
            while ((sortedUniqueNums.getOrNull(maxValueIndex) ?: Int.MAX_VALUE) <= maxValue) maxValueIndex++
            val operationCount = minValueIndex + (nums.size - maxValueIndex)
            bestOperationCount = min(bestOperationCount, operationCount)
        }
        return bestOperationCount
    }

}