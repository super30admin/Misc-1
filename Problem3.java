//Time -> O(n)
//Space -> O(n)

// class Solution{
//     public int depthSum(List<NestedInteger> nestedList){
//         Queue<NestedInteger> q = new LinkedList<>();
//         Queue<Integer> dq = new LinkedList<>();
//         for(NestedInteger e: nestedList){
//             q.add(e);
//             dq.add(1);
//         }
//         int result = 0;
//         while(!q.isEmpty()){
//             NestedInteger curr = q.poll();
//             int d = dq.poll();
//             if(curr.isInteger()){
//                 result += d * curr.getInteger();
//             }
//             else{
//                 for(NestedInteger el: curr.getList()){
//                     q.add(el);
//                     dq.add(d + 1);
//                 }
//             }
//         }
//         return result;
//     }
// }

class Solution{
    int result = 0;
    public int depthSum(List<NestedInteger> nestedList){
        dfs(nestedList, 1);
        return result;
    }
    private void dfs(List<NestedInteger> nestedList, int depth){
        for(NestedInteger e: nestedList){
            if(e.isInteger()){
                result += depth * e.getInteger();
            }
            else{
                dfs(e.getList(), depth + 1);
            }
        }
    }
}
