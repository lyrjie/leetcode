package easy.e706

// https://leetcode.com/problems/design-hashmap/

class MyHashMap {

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

    private var table: MutableList<Node<Int, Int>> = mutableListOf()

    fun put(key: Int, value: Int) {
        val keyHashCode = key.hashCode()

        val existingNode = getNode(key)

        if (existingNode != null) {
            existingNode.value = value
        } else {
            val node = Node(key, value, keyHashCode, null)
            val existingBucket = table.firstOrNull { it.hashCode == keyHashCode }
            if (existingBucket != null) {
                existingBucket.last.next = node
            } else {
                table.add(node)
            }
        }
    }

    fun get(key: Int): Int {
        return getNode(key)?.value ?: -1
    }

    fun remove(key: Int) {
        val keyHashCode = key.hashCode()
        val bucket = table.firstOrNull { it.hashCode == keyHashCode }
        if (bucket != null) {
            if (bucket.key == key) {
                table.remove(bucket)
                bucket.next?.let { table.add(it) }
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
    }

    private fun getNode(key: Int): Node<Int, Int>? {
        val keyHashCode = key.hashCode()
        for (bucket in table) {
            if (bucket.hashCode == keyHashCode) {
                var node: Node<Int, Int>? = bucket
                while (node != null) {
                    if (node.key == key) return node
                    node = node.next
                }
            }
        }
        return null
    }

}
