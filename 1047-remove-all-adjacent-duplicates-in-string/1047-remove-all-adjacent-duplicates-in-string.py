class Solution:
    def removeDuplicates(self, A: str) -> str:
        stack = deque([]);

        for char in A:

            if len(stack) == 0 :
                stack.append(char);
            elif stack[-1] != char:

                stack.append(char);
            else:
                stack.pop();
        return "".join(stack);