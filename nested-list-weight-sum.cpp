//Time - O(sum(d)+n) sum(d) is the depth of each element in the nestedList 
//Space - O(n) n - number of integers at any depth
class Solution {
    int depthSum(vector<NestedInteger> nestedList){
        queue<NestedInteger> q;
        int sum = 0;
        for(NestedInteger items:nestedList){
            q.push(items);
        }
        int depth = 1;
        while(!q.empty()){
            int size = q.size();
            while(size--){
                NestedInteger ele = q.front();q.pop();
                if(ele.isInteger()){
                    sum = sum + ele.getInteger()*depth;
                }else{
                    vector<NestedList> list = ele.getList();
                    for(NestedList e:list){
                        q.push(e);
                    }
                }
            }
            depth++;
        }
        
        return sum;
    }
};