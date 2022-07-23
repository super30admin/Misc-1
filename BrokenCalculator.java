//Method - 1 BFS- Brute Force

class Solution {

    //Time Complexity: 0(2^n) where n is the no. of nodes I will have to perform 2 operations to reach the target
    //Space Complexity: 0(n) where n is the no. of nodes resulting from performing the 2 operations

    public int brokenCalc(int startValue, int target) {
        if(startValue == target){
            return 0;
        }

        Queue<Integer> q = new LinkedList<>();  //Queue to perform BFS
        int count = 0;  //to calculate the total steps to reach the target
        q.add(startValue);  //I add the start value to the queue

        while(!q.isEmpty()){
            int size = q.size();    //getting the size as no. of levels gives the operations to be performed
            for(int i = 0; i < size; i++){
                int curr = q.poll();
                if(curr * 2 == target){ //if multiplying the current popped element by 2 give me target
                    return count + 1;   //I return count + 1 as I am doing one operation right now
                }
                if(curr - 1 == target){ //similarly, If subtraction 1 give me the target, I return count + 1
                    return count + 1;
                }
                if(curr > target){  //If it goes over target, I can only subtract so I put only that in the queue
                    q.add(curr - 1);
                }
                else{   //otherwise I perform both the operations and put it on to the queue
                    q.add(curr * 2);
                    q.add(curr - 1);
                }
            }
            count++;    //i also increase my count after every level
        }

        return count;   //I return count at the end
    }
}

//Method-2 Performing Division and Addition On target

class Solution {

    //Time Complexity: 0(log n) where n is the no of elemnts I have to perform operations on to reach the target
    //Space Complexity: 0(1)

    public int brokenCalc(int startValue, int target) {
        if(target == startValue){
            return 0;
        }

        int count = 0;

        while(target > startValue){ //until target  is greater than the start value, I run the loop
            if(target % 2 == 0){    //and if target divided by 2 is 0, then I divide the target by 2
                target = target / 2;
            }
            else{
                target = target + 1;    //or else, I add 1 so that it can be divisible by 2
            }
            count++;    //I increase my count as I have performed an operation
        }

        return count + (startValue - target);   //I am doing start - target because what if my target is 1 and start value is 20. Then 20-1 = 19, I will have to perform 19 additions to reach 20.
    }
}

