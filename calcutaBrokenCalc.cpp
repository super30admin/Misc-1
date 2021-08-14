/*
//BFS
//Time: Exponential
//Space:Exponential
class Solution {
public:
    int brokenCalc(int startValue, int target) {
        if(startValue == target) return 0;
        if(target < startValue) return startValue - target;
        queue<int> q;
        q.push(startValue);
        int ops = 0;
        while(!q.empty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int curr = q.front();
                q.pop();
                if(curr == target) return ops;
                if(curr < target){
                    q.push(curr * 2);
                    q.push(curr - 1);
                }
                else{
                    q.push(curr -1);
                }
            }
            ops++;
        }
        return ops;
    }
};

//Greedy
//Time : O(log (target))
//Space : O(1) No extra space
class Solution {
    int count;
public:
    int brokenCalc(int startValue, int target) {
        this->count = 0;
        while(startValue < target){
            if(target % 2 == 0)
                target/=2;
            else
                target++;
            count++;
        }
        return count + (startValue - target);
    }
};
*/
//DFS
class Solution {
public:
    int brokenCalc(int startValue, int target) {
        return dfs(startValue,target);
    }
    int dfs(int startValue, int target){
        if(startValue >= target) return startValue - target;
        if(target % 2 == 0) return dfs(startValue,target/2) + 1;
        else return dfs(startValue,(target+1))+1;
    }
};