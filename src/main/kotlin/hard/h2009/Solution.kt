package hard.h2009

class Solution {

    fun minOperations(nums: IntArray): Int {
        val sortedUniqueNums = nums.toSet().sorted()

        var bestOperationCount = Int.MAX_VALUE
        for (minValueIndex in sortedUniqueNums.indices) {
            val minValue = sortedUniqueNums[minValueIndex]
            val maxValue = minValue + nums.size - 1
            var operationCount = minValueIndex
            operationCount += nums.size - (binarySearch(sortedUniqueNums, maxValue) ?: sortedUniqueNums.size)
            if (operationCount < bestOperationCount) bestOperationCount = operationCount
        }
        return bestOperationCount
    }

    private fun binarySearch(list: List<Int>, target: Int): Int? {
        var left = 0
        var right = list.lastIndex
        var middle: Int
        while (left < right) {
            middle = (left + right) / 2
            if (list[middle] > target)
                right = middle
            else
                left = middle + 1
        }
        return if (list[left] > target) left else null
    }

}