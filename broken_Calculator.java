class Solution {
    public int brokenCalc(int startValue, int target) {
        int result = 0;
        while (target>startValue){
            if(target%2==0) target=target/2;
            else target = target+1;
            result++;
        }   
    return result+(startValue-target);
        }
}