from typing import List


class Solution:
    def __add_prefix(self, prefix: str, combinations: List[str]) -> List[str]:
        return map(lambda combination: prefix + combination, combinations)

    def __backtracking(self, opens: int, closes: int) -> List[str]:
        if opens == 0 and closes == 1:
            return [')']
        answer = []

        if opens > 0:
            combinations = self.__backtracking(opens - 1, closes)
            answer.extend(self.__add_prefix('(', combinations))
        if closes > 1 and opens < closes:
            combinations = self.__backtracking(opens, closes - 1)
            answer.extend(self.__add_prefix(')', combinations))
        return answer

    def generateParenthesis(self, n: int) -> List[str]:
        combinations = self.__backtracking(n - 1, n)
        return list(self.__add_prefix('(', combinations))
