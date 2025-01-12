#Approach
# Traverse through the list if the value is list again travese through the list and increase the level and solve it


#Complexities
#Time: O(depthof innerlist)
#Space: O(no of elements in the entirelist)





class Solution:

    def weightedNestedSum(self,nestedList):
        queue =[]
        result =0
        for obj in nestedList:
            queue.append((obj,1))

        while queue:
            (nlist,level) = queue.pop(0)
            if isinstance(nlist,list):
                for innerList in nlist:
                    queue.append((innerList,level+1))
            else:
                result+=(level*nlist)
        return result

class Solution:

    def weightedNestedSum(self,nestedList):
        self.result =0
        self.dfs(nestedList,1)
        return self.result

    def dfs(self,innerList,level):
        for object in innerList:
            if isinstance(object, int):
                self.result += (level * object)
            else:
                self.dfs(object,level+1)


s = Solution()
print(s.weightedNestedSum([[1,1],2,[1,1]]))
print(s.weightedNestedSum([1,[4,[6]]]))
