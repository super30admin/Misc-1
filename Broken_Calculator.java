// brute force, time limit exceeded 
// class Solution {
//     public int brokenCalc(int startValue, int target) {
//         if(startValue == target){
//             return 0;
//         }

//         Queue<Integer> q = new LinkedList<>();
//         q.add(startValue);
//         int level = 0;
//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i = 0; i < size; i++){
//                 int curr = q.poll();
//                 if(curr == target){
//                     return level;
//                 }
//                 if(curr <= 0){
//                     continue;
//                 }
//                 q.add(curr*2);
//                 q.add(curr-1);
//             }
//             level++;
//         }
//         return level;   
//     }
// }

// Time Complexity : O(logn)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int brokenCalc(int startValue, int target) {
        if(startValue == target){
            return 0;
        }   
        int iter =0;

        while(target> startValue){
            if(target %2 !=0){
                target += 1;
            }
            else{
                target /= 2;
            }
            iter++;
        }

        return iter + (startValue -  target);   
    }
}