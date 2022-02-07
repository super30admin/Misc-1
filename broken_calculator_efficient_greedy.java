 // Greedy approach
// Time complexity : O(log(target)) - performing division of 2.
// Space Complexity : O(1)  

class Solution {
    public int brokenCalc(int startValue, int target) {
        
        // Reverse approach
        // Assume / and + are working operators
        // start with the target
       
        int count = 0;
    
        // If target is greater, use the divide till it reaches the 
        while (target > startValue){
            
            // Divide directly if its an even number
            if (target % 2 == 0){
                
                target /= 2; 
            }
            
            // otherwise add one and divide
            else{
                
                target += 1;
            }
            
            count++; // one operation performed
        }
        
        
        // if target is less than the startValue
        return count +  startValue - target;
    }
}