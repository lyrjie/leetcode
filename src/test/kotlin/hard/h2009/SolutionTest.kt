package hard.h2009

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    private val solver = Solution()

    @Test
    fun exampleCase1() {
        val input = intArrayOf(4, 2, 5, 3)

        val result = solver.minOperations(input)

        assertEquals(0, result)
    }

    @Test
    fun exampleCase2() {
        val input = intArrayOf(1, 2, 3, 5, 6)

        val result = solver.minOperations(input)

        assertEquals(1, result)
    }

    @Test
    fun exampleCase3() {
        val input = intArrayOf(1, 10, 100, 1000)

        val result = solver.minOperations(input)

        assertEquals(3, result)
    }

    @Test
    fun failedCase1() {
        val input = intArrayOf(8, 5, 9, 9, 8, 4)

        val result = solver.minOperations(input)

        assertEquals(2, result)
    }

}