/*
Time: O(n)
Space: O(n)

Do double DFS
#1 find max_level (= weight of root level elements)
#2 start dfs level by level where root level elements have max_level weight
*/

class Solution {
public:
    /**
     * @param nestedList: a list of NestedInteger
     * @return: the sum
     */

    int dfs(NestedInteger v){
        if(v.isInteger())  return 1;
        else{
            int maxi = 0;
            for(NestedInteger ni: v.getList()){
                maxi = max(maxi, 1 + dfs(ni));
            }

            return maxi;
        }
    }

    int dfs2(NestedInteger v, int level){
        //if integer
        if(v.isInteger())  return v.getInteger() * level;
    
        int sum = 0;
        for(NestedInteger ni: v.getList()){
            //one level nested has one less weight
            sum += dfs2(ni, level-1);
        }

        return sum;
    }

    int depthSumInverse(vector<NestedInteger> list) {
        // find max_level (= weight of root level elements)
        int max_level = 0;
        for(NestedInteger ni: list)  max_level = max(max_level, dfs(ni));
        
        int sum = 0;
        //all first level elements have max_level weight 
        for(NestedInteger ni: list)  sum += dfs2(ni, max_level);

        return sum;
    }
};
