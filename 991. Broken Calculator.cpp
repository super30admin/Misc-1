/*
TC: O(log(n))
SC: O(1)
*/

class Solution {
public:
    //work backwards
    
    //divide target by 2 when number is even
    //add 1 when number is odd
    //if target falls below start, keep adding +1
    int brokenCalc(int start, int target) {
        int op = 0;
        while(start < target){
            if(target % 2)  target += 1;
            else  target /= 2;

            op++;
        }

        op += start - target; //when target falls below start, we have to keep adding +1
        return op;
    }
};
