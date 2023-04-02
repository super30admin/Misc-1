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

 /**
 The question is very tricky, We will be given a List of NestedInteger, a nested Integer is a class, that can either contain another list of NestedInteger or a single NestedInteger which holds a single value of type. We have return the sum of each integer multiplied by its depth. 

 Which means that whenever we are dealing with NestedInteger, we can expect either a list of NeNestedInteger or a single value.
 We can do this using DFS and BFS. With DFS, we will check if we the parameter is list, we will keep on recrusively passing it and incrementing the depth until we come to the single values. 
 If parameter is sinle value then we will just add it to the sum variable

 Time: O(n)
 Space : O(n)



  */
class Solution {
    int result =0;
    public int depthSum(List<NestedInteger> nestedList) {
        //DFS(nestedList,1);

       // return BFS(nestedList);
       return stackSolution(nestedList);
        
    }

    private void DFS(List<NestedInteger> list, int depth){
        //base case
        if(list == null){
            return;
        }
        //logic 
    
        for(int i=0;i<list.size();i++){
            if(list.get(i).isInteger()){
                result+= list.get(i).getInteger() * depth;
            }
            else{
                //recurse
                DFS(list.get(i).getList(),depth+1);
            }
        }
        }

    private int BFS(List<NestedInteger> list){
        int res =0;
        Queue<List<NestedInteger>> queue = new LinkedList<List<NestedInteger>>();
        int depth =1;
        queue.add(list);

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i=0;i<size;i++){
                List<NestedInteger> current = queue.poll(); // current will always be a list , as for single integers, we are already adding it up
                    for(int j=0;j<current.size();j++){

                        if(current.get(j).isInteger()){
                            res += current.get(j).getInteger() * depth;
                        }
                        else{
                            queue.add(current.get(j).getList());
                        }
                    }
                
            }


            depth++;

        }
        return res;

    }



    private int stackSolution(List<NestedInteger> list){

        Stack<Integer> depthStack = new Stack<Integer>();
        Stack<List<NestedInteger>> listStack = new Stack<List<NestedInteger>>();
        int depth =1;
        int sum =0;
        // when ever we see the nested list , we will push it into the stack along with its depth

        depthStack.push(depth);
        listStack.push(list);

        while(!listStack.isEmpty()){
            List<NestedInteger> currentList = listStack.pop();
            int d = depthStack.pop();

            for(NestedInteger element : currentList){
                if(element.isInteger()){
                    sum += element.getInteger() * d;
                }
                else{
                    listStack.push(element.getList());
                    depthStack.push(d+1);
                }
            }
        }
        return sum;


    }
    }









