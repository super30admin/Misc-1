#include<iostream>

using namespace std;

class Solution {
public:
    int brokenCalc(int startValue, int target) {
        if(target <= startValue) return startValue-target;
        int cnt{};
        while(target>startValue){
            cnt++;
            if(target%2==1){
                target++;
            }
            else{
                target = target/2;
            }
        }
        return cnt + startValue - target;
    }
};