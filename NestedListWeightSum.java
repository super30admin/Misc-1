import java.util.List;

//Time Complexity: O(N); where N is total number of nested elements in the list.
//Space Complexity: O(N)

public class NestedListWeightSum {
	/**Approach1: DFS**/
	int res;
	public int depthSum(List<NestedInteger> nestedList) {
		dfs(nestedList, 1);
		return res;
	}
	private void dfs(List<NestedInteger> nestedList, int depth) {
		for (NestedInteger element : nestedList) {
			if (element.isInteger()) {
				res += depth * element.getInteger();
			} else {
				dfs(element.getList(), depth + 1);
			}
		}
	}
	/**Approach2: BFS**/
	/*public int depthSum(List<NestedInteger> nestedList) {    
        Queue<NestedInteger> q= new LinkedList<>();
        Queue<Integer> depth= new LinkedList<>();
        for(NestedInteger element: nestedList){
            q.add(element);
            depth.add(1);
        }
        int res=0;
        while(!q.isEmpty()){
            NestedInteger curr = q.poll();
            int currDepth = depth.poll();
            if(curr.isInteger()){
                res += currDepth * curr.getInteger();
            }else{
                for(NestedInteger element: curr.getList()){
                    q.add(element);
                    depth.add(currDepth + 1);
                }
            }
        }
        return res;
    }*/	
}
