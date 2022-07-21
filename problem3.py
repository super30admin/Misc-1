# Problem 3: Weight sum of a nested List 
# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


def depthSum(l):
    sum=0
    def dfs(l, depth):
        for i in l:
            if (i.isInteger()):                 #if the current element is an integer, add its number times the depth to the sum
                sum+= i.getInteger()*depth
            else:
                dfs(i.getList(), depth+1)       #if its a list, call the function recursively and add the depth
    dfs(l, 1)
    return sum
