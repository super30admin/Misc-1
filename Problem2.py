#Time complexity : O(n)
#Space complexity: O(1)
#Works on leetcode : yes
#Approach : We iterate through the nested list depth by depth and at each depth we get the sum of integers multiplied by depth. The
#nestedList is updated to concatination of list contained in next depth. 

class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        depth, res = 1, 0
        while nestedList:
            res += depth* sum([x.getInteger() for x in nestedList if x.isInteger()])
            #nestedList = sum([x.getList() for x in nestedList ],[])
            nestedList = nestedList = [i for  x  in nestedList for i in x.getList()  ]
            depth +=1
        return res