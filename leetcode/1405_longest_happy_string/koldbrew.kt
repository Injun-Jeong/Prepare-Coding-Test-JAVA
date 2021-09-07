class Solution {
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        var result = ""
        val map = mutableMapOf("a" to a, "b" to b, "c" to c)

        for (i in 0 until a + b + c) {
            val candidates = map.entries.sortedBy { it.value }.reversed()
            if (candidates[0].value >= 1) {
                // 이미 두 번 연속된 경우, 다음 큰 수를 택함.
                if (isRepeatedTwice(result, candidates[0].key)) {
                    if (candidates[1].value > 0) {
                        result += candidates[1].key
                        map[candidates[1].key] = candidates[1].value - 1
                    }
                } else {
                    result += candidates[0].key
                    map[candidates[0].key] = candidates[0].value - 1
                }
            }
        }
        return result
    }

    private fun isRepeatedTwice(str: String, key: String): Boolean{
        return str.length >= 2 && str.substring(str.length - 2) == key.repeat(2)
    }
}
