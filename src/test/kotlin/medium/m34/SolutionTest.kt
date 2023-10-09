package medium.m34

import org.junit.Test
import org.junit.Assert.*

class SolutionTest {

    private val solver = Solution()

    @Test
    fun exampleCase1() {
        val array = intArrayOf(5, 7, 7, 8, 8, 10)
        val target = 8

        val result = solver.searchRange(array, target)

        assertArrayEquals(intArrayOf(3, 4), result)
    }

    @Test
    fun exampleCase2() {
        val array = intArrayOf(5, 7, 7, 8, 8, 10)
        val target = 6

        val result = solver.searchRange(array, target)

        assertArrayEquals(intArrayOf(-1, -1), result)
    }

    @Test
    fun exampleCase3() {
        val array = intArrayOf()
        val target = 0

        val result = solver.searchRange(array, target)

        assertArrayEquals(intArrayOf(-1, -1), result)
    }

}