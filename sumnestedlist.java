//TC: O(N): each NestedInteger (list or integer) is pushed/popped at most once.
//SC: O(N): explicit stacks store up to all elements in the worst case (≈ depth/width of nesting).

//Push all top-level items with level=1 onto parallel stacks.
//Iteratively pop: if integer, add value*level to result; if list, push its children with level+1.
//Continue until stacks empty; return the accumulated result.

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Stack<NestedInteger> st = new Stack<>();
        Stack<Integer> levelSt = new Stack<>();
        int result = 0;
        int level = 1;

        for(NestedInteger ne: nestedList){
            st.push(ne);
            levelSt.push(1);
        }

        while(!st.isEmpty()){
            NestedInteger curr = st.pop();
            level = levelSt.pop();

            if(curr.isInteger()){
                result += curr.getInteger() * level;
            }else{
                for(NestedInteger ne: curr.getList()){
                    st.push(ne);
                    levelSt.push(level+1);
                }
            }
        }

        return result;
    }
}