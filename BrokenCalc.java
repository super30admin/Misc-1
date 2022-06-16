//TC : O(Log(T+k)) here t = target and k = additional remaining 1's 
//SC : O(1)

class Solution { 
    public int brokenCalc(int startValue, int target) { // We are starting from target and just dividing by 2 or adding 1 into it   
        int minSteps = 0;        
        while(target > startValue){
            if(target % 2 == 0) target = target / 2; // If target is divisible by 2
            else{
                target++; // Else increment by 1 
            }
            minSteps++;
        }
        
        return minSteps + startValue - target; //for remaining 1's which we will be adding if becomes target < 0
    }
}

/*
//Time limit exceeded - TC is exponential
 class Solution {
    public int brokenCalc(int startValue, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startValue);
        int minSteps = 0;
        
        while(!queue.isEmpty()){
            int len = queue.size();
            while(len-- > 0){
                int i = queue.poll();
                if(i == target )    return minSteps;
                
                if(i < target)  queue.add(i * 2);
                
                if(target > 0 && i > 2) queue.add(i - 1);
            }
            minSteps++;
        }
        return -1;
    }
}   
    */