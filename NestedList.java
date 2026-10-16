/**
 * Time Complexity:  O(n)  where n is the length of the array
 * Space Complexity: O(n)
 */
class Solution {

    public int depthSum(List<NestedInteger> nestedList) {
        int depth = 1;
        return calculateSum(nestedList, depth);
    }

    private int  calculateSum(List<NestedInteger> nestedList, int depth){
        int output=0;
        for(NestedInteger nestedElement : nestedList){
            if(nestedElement.isInteger()){
                output += nestedElement.getInteger() * depth;
            }else{
                output +=   calculateSum(nestedElement.getList(), depth+1);
            }
        }

        return output;
    }

}