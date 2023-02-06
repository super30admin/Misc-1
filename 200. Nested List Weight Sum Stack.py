class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        total = 0
        st = list()
        depth = list()

        for nl in nestedList:
            st.append(nl)
            depth.append(1)

        while st:
            currDepth = depth.pop()
            curr = st.pop()
            if curr.isInteger():
                total += currDepth * (curr.getInteger())
            else:
                for nl in curr.getList():
                    st.append(nl)
                    depth.append(currDepth + 1)

        return total

# Stack Iterative
# Space complexity: O(n)
# Time complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
