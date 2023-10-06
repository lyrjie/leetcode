package easy.e706

import junit.framework.Assert.assertEquals
import org.junit.Test

class MyHashMapTest {

    @Test
    fun exampleCase1() {
        var result: Int? = null

        val myHashMap = MyHashMap()
        myHashMap.put(1, 1)
        myHashMap.put(2, 2)
        result = myHashMap.get(1)
        assertEquals(1, result)
        result = myHashMap.get(3)
        assertEquals(-1, result)
        myHashMap.put(2, 1)
        result = myHashMap.get(2)
        assertEquals(1, result)
        myHashMap.remove(2)
        result = myHashMap.get(2)
        assertEquals(-1, result)
    }
}