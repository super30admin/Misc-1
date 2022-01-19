//Time complexity:- 0(log(y)); as we are dividing the number into half.
//space complexity:- O(1)
class Solution {
    public int brokenCalc(int startValue, int target) {
        int count=0;
        if(target>startValue){
            while(target>startValue){
                if(target%2==0){
                    target=target/2;
                }
                else{
                    target++;    //from destination to source approach because while doing so we can have only 
                                 // one. choice not two choices 
                }
                count++;
            }
            count=count+startValue-target;
            
        }
        else{
            count=count+startValue-target;
        }
        return count;
    }
}