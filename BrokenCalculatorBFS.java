// BFS
// Time complexity = O(2^n) (exponential)
// Space complexity = O(n) for the queue.

class Solution {
    public int brokenCalc(int startValue, int target) {
        int count=0;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(startValue);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i< size;i++) {
                int val = q.remove();
                if(val == target) {
                    return count;
                }        
                // No is less than the target.
                if(val < target ) {
                    int mul = val*2;
                    if(!set.contains(mul)) {
                        set.add(mul);
                        q.add(mul);    
                    }                    
                }
                if(val>0) {// the only time it does not make sense to subtract 1 is when the numbers are -ve.
                    int sub = val-1;
                    if(!set.contains(sub)) {
                        set.add(sub);
                        q.add(sub);    
                    }
                }
                
                }
            count++;
        }
        return 1111;
    }
}