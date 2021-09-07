class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        return when (nums.count { it == 0 }) {
            0 -> {
                val total = nums.reduce { acc, i -> acc * i }
                nums.map { total / it }.toIntArray()
            }
            1 -> {
                val total = nums.reduce { acc, i -> if (i != 0) acc * i else acc }
                nums.map { if (it != 0) 0 else total }.toIntArray()
            }
            else -> {
                nums.map { 0 }.toIntArray()
            }
        }
    }
}
