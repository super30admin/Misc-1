// TC: O(log(target)) + O(k)
// SC: O(1)
public int brokenCalc(int startValue, int target) {
    int count = 0;
    while(target>startValue){
        count++;
        if(target%2 == 1) target++;
        else target /= 2;
    }

    return count + startValue - target;
}