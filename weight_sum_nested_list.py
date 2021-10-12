#Time Complexity: O(N) where N is #number of nested lists
#Space Complexity : O(N)
class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        total = 0
        if not nestedList or len(nestedList)==0:
            return 0
        stack = []
        
        stack.append((nestedList,1))
        while(stack):
            (popped,sz) = stack.pop()
            
            for element in popped:
                #int
                if element.isInteger():
                    total+=element.getInteger()*sz
                else:
                    stack.append((element.getList(),sz+1))
            
                
                        
        return total
        