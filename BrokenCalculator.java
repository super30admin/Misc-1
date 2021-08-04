import java.util.*;

public class BrokenCalculator {

     //Greedy approach instead of starting from the begining. Start from the end. and reverse the operation.
    //TC: O(log N) Where n is the target value. It decreases value by half, half and goes on until it becomes less. Then just increment. But it will be less.
    //SC: O(log N)
    public int brokenCalc(int startValue, int target) { 
        int steps = 0;
        
        while(target >= startValue) {
            if(target == startValue) return steps;
            
            if(target % 2 == 0) {
                target = target / 2;
            } else {
                target = target + 1;
            }
            steps++;
        }
        //if target becomes lesser then we must do negative -1
        //So, startvalue - target gives decrement 1 step
        return steps + (startValue - target);
    }

    //TC: O(2^N) Where N is the start value. Each step we are taking two decision 
    //SC: O(2^N) 
    public int brokenCalcBFS(int startValue, int target) {
        Queue<Integer> queue = new LinkedList();
        queue.add(startValue);
        
        int result = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int current = queue.poll();
                if(current == target) {
                    return result;
                }
                else if(current > target){
                    queue.add(current - 1);
                } else {
                    queue.add(current * 2);  
                    queue.add(current - 1);
                }    
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        
    }
}