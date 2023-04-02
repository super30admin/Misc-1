/*

This question is very ticky

The intuition tells us to solve this problem using DFS or BFS, but both do not work. BFS would give us an exponential solution.

Instead , we can reverse the problem

The question tells is to go from start to target using multiply by 2 and subtract by 1 operaation and find the number of steps required to do that

Instead , we will reverse the question
We will say, we have to go from target to source using div by 2 and add by 1

1) If the target is greater than source then : check if target is even, if so divide by 2 , else increment the target by one to make it even
2) count the steps until the above operation completes
3) in any case , add the difference between the start and target , as target may be smaller this time
4) return the number of steps

Time : O(logn)
Space : O(1)
*/

class Solution {

    public int brokenCalc(int startValue, int target) {

        //we will reverse the question and solve it that way
        // and we will also reverse the operations available, insead of multiply by 2 , we will /2 and subtract would change to add

      
        int steps = 0;
        if(target > startValue){ // if the t
            while(target >startValue){
                if(target % 2 ==0)target = target/2; // if its is even, then keep dividing
                else target++; // else add one to it and at the end it will automatically adding in to the steps
                steps++;
            }
            
        }

        steps += startValue - target;
        return steps;


    }

    // The below is an exponential solution 2 ^ n,and gives time limit exceeds
    // procesing it level by level may help
    private int BFS(int s, int t){

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        int steps=0;

        while(!queue.isEmpty()){

            int size = queue.size();

            while(size >0){
            int current = queue.poll();
            if(current == t){
                return steps;
            }

            // we will multiply only if its less than the target
            if(current < t){
                queue.add(current *2);
            }
            if(current > 1){
                queue.add(current -1);
            }
            size--;
            }
            steps++;
        }

        return -1;

    }


    // The below soltion of recursion will not work, as it will keep going towards the base problem again and again
    // e.g s=2 , t =3 . 2 -1 -> 1 * 2 ->2 

    int minCounter = Integer.MAX_VALUE;
    // DFS Solution
    private void recurse(int s , int t, int op){

        //base case
        if(s == t){
            if(op < minCounter){
                minCounter = op;
            }
            return;
        }

        //logic
        // multiply choice
        if(s < t){
            recurse(s*2 , t, op+1);
        }
        //subtract choice
        if(s > 1){ // sometimes subtracting it first and then multiplying would take shorter number of operations
            recurse(s-1,t, op+1);
        }
        
    }
}