# Problem 3: Weight sum of a nested List (https://leetcode.com/problems/nested-list-weight-sum/)
# Time Complexity: O(N),N = total number of integers and nested lists combined. Every item is pushed and popped exactly once, so the work grows in a straight line with input size.
# Space Complexity: O(N),In the worst case, the stacks can hold a large number of items at once, so the extra memory grows with N too.
# Approach:
# Use two stacks that work together: one stack holds the items (numbers or lists), the other stack holds the depth of each item. 
# Start by pushing everything from the outer list at depth 1. 
# Then keep popping: if the popped item is a number, multiply it by its depth and add to the result. 
# If it's a list, push its contents back in at depth+1. Keep going until nothing is left.

class Solution:
    def depthSum(self, nestedList):
      stack = []          # will hold the actual items (numbers or lists) waiting to be processed
      levelstack = []     # will hold the depth that matches each item in "stack", same order
      result = 0          # running total of (number * depth), this is what we return at the end
      level = 1            # temporary variable, gets overwritten each loop, just needed to exist first

      # Step 1: put every item from the outer list into "stack"
      # every one of these items is directly in the outer list, so depth = 1
      for i in nestedList:
        stack.append(i)          # add the item itself
        levelstack.append(1)     # add its depth (always 1 here, since it's top level)

      # Step 2: keep working until "stack" is empty
      while stack:
        current = stack.pop()        # take the last item out of "stack"
        level = levelstack.pop()     # take the matching depth out of "levelstack"
        # current and level always belong together, since they were pushed together

        if current.isInteger():
          # this item is a plain number, not a list
          result += current.getInteger() * level
          # multiply the number by how deep it is, add that to our running total

        else:
          # this item is actually a list, not a number
          # so we need to look inside it and process everything it contains
          for i in current.getList():     # FIXED: was current.getInteger(), that is wrong here
            stack.append(i)                # push each inner item back into "stack"
            levelstack.append(level + 1)   # it is one level deeper than "current" was, so level + 1

      # once "stack" is empty, every number has been counted
      return result
