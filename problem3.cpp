/*
// Time Complexity : O(N) number of elements
// Space Complexity : O(M) number of nested list
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
*/

#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    int res{};
    void gg_sum(vector<NestedInteger>& nestedList,int depth){
        for(NestedInteger nl:nestedList){
            if(nl.isInteger()){
                res+= nl.getInteger()*depth;
            }
            else{
                gg_sum(nl.getList(),depth+1);
            }
        }
    }
    int depthSum(vector<NestedInteger>& nestedList) {
        int depth{1};
        for(NestedInteger nl:nestedList){
            //cout<<nl.isInteger()<<"\t";
            if(nl.isInteger()){
                res+= nl.getInteger()*depth;
            }
            else{
                gg_sum(nl.getList(),depth+1);
            } 
        }
        return res;
    }
};

