 // Brute force approach
// Time complexity : O(2^n) : Each numnber has 2 options (*, -)
// Space Complexity : O(1)  

class Solution {
    public int brokenCalc(int startValue, int target) {
        
       
        int count =0;
        
        // BFS
        
        Queue<Integer> queue =  new LinkedList();
        queue.add(startValue);
        
        
        while (!queue.isEmpty()){
            
            // level variable
            int size = queue.size();
            
            for (int i =0; i < size; i++){
                
                // poll the element
                int curr = queue.poll();
                
                if (curr == target){
                    
                    return count; // found
                }
                else{
                    
                    if (curr < target){
                        
                        // multiply and subtract
                        queue.add(curr * 2);
                        queue.add(curr - 1);
                    }
                    else {
                        // multiply will be greater than the target value
                        queue.add(curr - 1);
                    }
                    
                }
            }
            
            count++;
        }
        
        
        // never possible case
        return -1;
    }
}