from functools import reduce
from typing import List


class Solution:
    def __init__(self):
        self.zero_count = None
        self.product_of_array = None

    def __get_answer(self, value: int) -> int:
        if value == 0:
            if self.zero_count > 1:
                return 0
            return self.product_of_array

        if self.zero_count > 0:
            return 0
        return int(self.product_of_array / value)

    def productExceptSelf(self, nums: List[int]) -> List[int]:
        self.zero_count = nums.count(0)
        self.product_of_array = reduce(lambda num1, num2: num1 * num2 if num2 != 0 else num1, nums, 1)
        return [self.__get_answer(num) for num in nums]
