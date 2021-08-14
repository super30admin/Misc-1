/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *   public:
 *     // Constructor initializes an empty nested list.
 *     NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     NestedInteger(int value);
 *
 *     // Return true if this NestedInteger holds a single integer, rather than a nested list.
 *     bool isInteger() const;
 *
 *     // Return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     int getInteger() const;
 *
 *     // Set this NestedInteger to hold a single integer.
 *     void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     void add(const NestedInteger &ni);
 *
 *     // Return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     const vector<NestedInteger> &getList() const;
 * };
 */
/*
//DFS
Time : O(N) where N is the total number of elements
Space: O(S) where S is the highest depth of nesting
class Solution {
    int result;
public:
    void dfs(NestedInteger element, int depth){
        //logic
        if(element.isInteger()) result+= depth*element.getInteger();
        else{
            for(auto ele : element.getList()){
                dfs(ele,depth+1);
            }
        }
    }
    int depthSum(vector<NestedInteger>& nestedList) {
        this->result = 0;
        for(auto ele : nestedList){
            dfs(ele,1);
        }
        return result;
    }
};
*/
//BFS
class Solution {
    int result;
public:
    int depthSum(vector<NestedInteger>& nestedList) {
        this->result = 0;
        queue<NestedInteger> q;
        int level = 1;
        for(auto ele : nestedList){
            q.push(ele);
        }
        while(!q.empty()){
            int size = q.size();
            for(int i = 0;i < size;i++){
                auto curr = q.front();
                q.pop();
                if(curr.isInteger()) result += level * curr.getInteger();
                else{
                    for(auto ele : curr.getList()){
                        q.push(ele);
                    }
                }
            }
            level++;
        }
        return result;
    }
};