// Time Complexity : O(log target)
// Space Complexity :O(1)
class Solution {
    public int brokenCalc(int startValue, int target) {
        int res=0;
        while(target>startValue){
            if(target%2==0){
                target=target/2;
            }else{
                target=target+1;
            }
            res++;
        }
        
        return res + startValue - target;
    }
}