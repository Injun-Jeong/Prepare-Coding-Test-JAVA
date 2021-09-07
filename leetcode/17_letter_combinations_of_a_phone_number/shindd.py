from typing import List


class Solution:
    def __init__(self):
        self.digits_map = {
            2: ['a', 'b', 'c'],
            3: ['d', 'e', 'f'],
            4: ['g', 'h', 'i'],
            5: ['j', 'k', 'l'],
            6: ['m', 'n', 'o'],
            7: ['p', 'q', 'r', 's'],
            8: ['t', 'u', 'v'],
            9: ['w', 'x', 'y', 'z']
        }

    def __get_letters(self, digit: str) -> List[str]:
        assert self.digits_map.get(int(digit))
        return self.digits_map.get(int(digit))

    def __backtracking(self, index: int, digits: str) -> List[str]:
        digit = digits[index]
        letters = self.__get_letters(digit)
        if index == len(digits) - 1:
            return letters

        answer = []
        for letter in letters:
            combinations = self.__backtracking(index + 1, digits)
            for combination in combinations:
                answer.append(letter + combination)
        return answer

    def letterCombinations(self, digits: str) -> List[str]:
        if len(digits) == 0:
            return []
        return self.__backtracking(0, digits)
