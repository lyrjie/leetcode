package easy.e706

// https://leetcode.com/problems/design-hashmap/

class MyHashMap {

    companion object {
        private const val BUCKET_CAPACITY = 1000
    }

    private data class Node<K, V>(
        val key: K,
        var value: V,
        val hashCode: Int,
        var next: Node<K, V>?
    ) {
        val last: Node<K, V>
            get() {
                var node = this
                while (true) {
                    val next = node.next
                    if (next != null)
                        node = next
                    else
                        return node
                }
            }
    }

    private var table: Array<Node<Int, Int>?> = arrayOfNulls(BUCKET_CAPACITY)

    fun put(key: Int, value: Int) {
        val keyHashCode = key.hashCode()

        val existingNode = getNode(key)

        if (existingNode != null) {
            existingNode.value = value
        } else {
            val node = Node(key, value, keyHashCode, null)
            val existingBucket = table[index(key)]
            if (existingBucket != null) {
                existingBucket.last.next = node
            } else {
                table[index(key)] = node
            }
        }
    }

    fun get(key: Int): Int {
        return getNode(key)?.value ?: -1
    }

    fun remove(key: Int) {
        val bucketIndex = index(key)
        val bucket = table[bucketIndex]
        if (bucket?.key == key) {
            table[bucketIndex] = bucket.next
        } else {
            var previous: Node<Int, Int>? = null
            var node: Node<Int, Int>? = bucket
            while (node != null) {
                if (node.key == key) {
                    if (previous != null) {
                        previous.next = node.next
                    }
                }
                previous = node
                node = node.next
            }
        }
    }

    private fun getNode(key: Int): Node<Int, Int>? {
        val bucketIndex = index(key)
        val bucket = table[bucketIndex]
        var node: Node<Int, Int>? = bucket
        while (node != null) {
            if (node.key == key) return node
            node = node.next
        }
        return null
    }

    private fun index(key: Int): Int {
        return (BUCKET_CAPACITY - 1) and key.hashCode()
    }

}
