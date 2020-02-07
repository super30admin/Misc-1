
TC: O(n);
SC: O(n)

Runtime: 0 ms, faster than 100.00% of Java online submissions for Nested List Weight Sum.

Approach: We traverse the element of the list and when ever we find a nested list , we use recursion with increasing the depth.AFter multi
plying the number with the depth we update the sum.

class Solution {
    int sum = 0;
    public int depthSum(List<NestedInteger> nestedList) {
         if(nestedList == null || nestedList.size() == 0){
             return 0;
         }
        recursion(nestedList, 1);
        return sum;
    }
    
    private void recursion (List<NestedInteger> nestedList , int depth){
        for(NestedInteger nes : nestedList){
            if(nes.isInteger()){
                sum+= nes.getInteger()*depth;
            }else{
                recursion(nes.getList(),depth+1);
            }
        }
    }
    
    
    
}
