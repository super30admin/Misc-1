/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

//DFS method
class Solution {

    //Time Complexity: 0(n) where n is the elements in my list. I dont consider depth because constraints say that max dept can be 50 which is a constant
    //Space Complexity : 0(n)

    int sum;    //variable sum to calculate the the sum of integers as per their levels
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0){
            return 0;
        }
        dfs(nestedList, 1); //calling my dfs method with initial depth of 1
        return sum; //returning sum
    }

    public void dfs(List<NestedInteger> nestedList, int depth){
        for(NestedInteger el : nestedList){ //going over each and every element in my nested list
            if(el.isInteger()){ //calling the is integer function and checking if the current element is integer or not
                sum = sum + el.getInteger() * depth;    //if it is, adding it to prev sum and multiplying the current integer by the dept and adding it to the sum
            }
            else{   //else it is not an integer and it is a list so again calling my dfs method to further extract the integer
                dfs(el.getList() , depth + 1);  //also increasing the depth as I am moving into nested list
            }
        }
    }
}


//Solution Using stack
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0){
            return 0;
        }

        int sum = 0;
        Stack<NestedInteger> s = new Stack <>();    //Stack to hold the nested integers
        Stack<Integer> depth = new Stack <>();  //stack to hold depth

        for(NestedInteger el : nestedList){ //pishing all the elemets in my stack
            s.push(el);
            depth.push(1);  //also the dept current is only because I have not started to unwind my nested list
        }

        while(!s.isEmpty()){    //tills tack is not empty
            NestedInteger curr = s.pop();   //getting the current element
            int dep = depth.pop();  //getting the depth
            if(curr.isInteger()){   //checking if it is integer
                sum = sum + curr.getInteger() * dep;    //if it is, then adding it to sum
            }
            else{   //if not
                for(NestedInteger el : curr.getList()){//then unwinding the list of list and pushing elements onto the stack
                    s.push(el);
                    depth.push(dep + 1);    //also increasing dept because the unwinding of list is happening and I am entering another level now
                }
            }
        }
        return sum; //returning the final sum at the end
    }
}

//Queue Implementation

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0){
            return 0;
        }

        int sum = 0;
        Queue<NestedInteger> q = new LinkedList<>();
        int depth = 1;

        for(NestedInteger el : nestedList){
            q.add(el);
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                NestedInteger curr = q.poll();
                if(curr.isInteger()){
                    sum = sum + curr.getInteger() * depth;
                }
                else{
                    for(NestedInteger el : curr.getList()){
                        q.add(el);
                    }
                }
            }
            depth++;
        }
        return sum;
    }
}