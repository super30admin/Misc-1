class Solution:
    def depth_sum(self, nested_list):
        # TC : O(n)
        # SC : O(1)
        
        def dfs(current_list, current_depth):
            current_depth_sum = 0  

            for item in current_list:
                if item.isInteger():
                    # If the item is an integer, add its value times the current depth
                    current_depth_sum += item.getInteger() * current_depth
                else:
                    # If the item is a list, recursively call dfs to calculate its depth sum
                    current_depth_sum += dfs(item.getList(), current_depth + 1)
          
            return current_depth_sum  # Return the calculated depth sum for this level

        return dfs(nested_list, 1)  # Start the depth-first search with the top-level list and depth 1
