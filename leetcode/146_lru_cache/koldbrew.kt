class LRUCache(capacity: Int) {
    private val maxSize = capacity
    private val cache = LinkedHashMap<Int, Int>(capacity, 1.0F, true)
    private val cacheSize
        get() = cache.keys.size

    fun get(key: Int): Int? = if(cache.containsKey(key)) cache[key] else -1

    fun put(key: Int, value: Int) {
        if(!cache.containsKey(key) && cacheSize == maxSize) {
            val headKey = cache.keys.iterator().next()
            cache.remove(headKey)
        }
        cache[key] = value
    }
}
