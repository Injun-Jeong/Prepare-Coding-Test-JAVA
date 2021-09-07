class Solution {

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        val numberMap = HashMap<String, String>().apply {
            put("2", "abc")
            put("3", "def")
            put("4", "ghi")
            put("5", "jkl")
            put("6", "mno")
            put("7", "pqrs")
            put("8", "tuv")
            put("9", "wxyz")
        }

        var results = numberMap[digits[0].toString()]?.toCharArray()?.map { it.toString() } ?: listOf()
        if (digits.length == 1) {
            return results
        } else {
            for (index in 1 until digits.length) {
                val digit = digits[index].toString()
                val candidates = numberMap[digit]?.toCharArray() ?: charArrayOf()
                val temp = mutableListOf<String>()

                results.forEach {
                    candidates.forEach { candidate ->
                        temp.add("$it$candidate")
                    }
                }
                results = temp.toList()
            }
        }

        return results
    }
}
