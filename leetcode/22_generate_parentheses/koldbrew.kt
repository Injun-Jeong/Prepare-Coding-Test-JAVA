class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val results = mutableListOf<String>()
        create(results, "(", n, 1, 1)
        return results
    }

    private fun create(list: MutableList<String>, str: String, n: Int, count: Int, stackSize: Int) {
        if(count > n*2 || stackSize < 0 || str.count { it == '(' } > n) return

        if(count == n*2) list.add(str)

        create(list, "$str(", n, count + 1, stackSize + 1)
        create(list, "$str)", n, count + 1, stackSize - 1)
    }
}
