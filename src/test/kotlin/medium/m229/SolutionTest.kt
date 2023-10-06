package medium.m229

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    private val solver = Solution()

    @Test
    fun exampleCase1() {
        val input = intArrayOf(3, 2, 3)

        val result = solver.majorityElement(input)

        assertEquals(listOf(3), result)
    }

    @Test
    fun exampleCase2() {
        val input = intArrayOf(1)

        val result = solver.majorityElement(input)

        assertEquals(listOf(1), result)
    }

    @Test
    fun exampleCase3() {
        val input = intArrayOf(1, 2)

        val result = solver.majorityElement(input)

        assertEquals(listOf(1, 2), result)
    }

}