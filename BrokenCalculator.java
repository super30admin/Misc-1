// Approach : Form a decision tree with two decisions and perform BFS (min operations) -- > Time limit Exceeded for larger inputs
// Maintain a visited set to avoid already visited numbers
// Time : O(n)
// Space: O(n) // visited set
class Solution {
    public int brokenCalc(int startValue, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startValue);

        HashSet<Integer> set = new HashSet<>();// visited numbers
        set.add(startValue);

        int steps =0; // we process level by level because we are looing for operations
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int curr = q.poll();
                if(curr == target) return steps;
                if(curr<target) {
                    // only here x2 operation is available
                    int ne = curr*2;
                    if(!set.contains(ne)){
                        set.add(ne);
                        q.add(ne);
                    }
                }
                if(curr>1){
                    // only here -1 opertaion is available
                    int ne = curr-1;
                    if(!set.contains(ne)){
                        set.add(ne);
                        q.add(ne);
                    }
                }
            }
            steps++;
        }
        return steps;
    }
}

// Approach : Form a decision tree with two decisions and perform DFS. With DFS you have to explore each and every path and take the min of it
// There won't be any visited set because need to explore all the paths. 
// DFS Drawback : for certain input - 2 with target 3 . Recursion in the decision tree will be infinite loop and never come out of the stack.

// Approach 3: Greedy 
// Check with interviewer if it is okay to use '/' and '+' so that we can form the decision tree with regular operations and identify the optimal branch and 
// from that optimal branch start looking the tree from bottom to start value utilizing / or + operations.
// If the target value is odd then + operation . If it is even value then / operation.
// By doing so if at any point if the value < start value
// Time Complexity : O(logn) // because of / we are reducing the i/p by half
// Space Complexity : 
// Approach 3: Greedy 
// Intution : Check with interviewer if it is okay to use '/' and '+' so that we can form the decision tree with regular operations and identify the optimal branch and 
// from that optimal branch start looking the tree from bottom to start value utilizing / or + operations.
// So we start from the target value and if the target value is odd then + operation . If it is even value then / operation.
// By doing so if at any point if the value < start value
// Time Complexity : O(logn) // because of / we are reducing the i/p by half
// Space Complexity : 
class Solution {
    public int brokenCalc(int startValue, int target) {
        int count =0;
        while(target > startValue){
            // Target is even
            if(target % 2 ==0){
                target = target /2; // this will reduce the i/p by half
            } else{
                // target is odd
                target = target + 1;
            }
            count ++;
        }
        return count + (startValue - target); // when target becomes less than startValue then we need additional one operation to make it to startValue;
    }
}