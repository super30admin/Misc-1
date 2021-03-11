//Time - O(logY)
//Space - O(1)
class Solution {
public:
    int brokenCalc(int X, int Y) {
        int cnt = 0;
        
        while(Y>X){
            if(Y%2 == 0){
                Y = Y/2;
            }else{
                Y = Y+1;
            }
            cnt++;
        }
        
        cnt = cnt + X-Y;
        return cnt;
        
    }
};