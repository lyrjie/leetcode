package medium.m343

import org.junit.Test
import org.junit.Assert.*

class SolutionTest {

    private val solver = Solution()

    @Test
    fun exampleCase1() {
        val input = 2

        val result = solver.integerBreak(input)

        assertEquals(1, result)
    }

    @Test
    fun exampleCase2() {
        val input = 10

        val result = solver.integerBreak(input)

        assertEquals(36, result)
    }

    @Test
    fun failedCase1() {
        val input = 3

        val result = solver.integerBreak(input)

        assertEquals(2, result)
    }

    @Test
    fun failedCase2() {
        val input = 5

        val result = solver.integerBreak(input)

        assertEquals(6, result)
    }

}