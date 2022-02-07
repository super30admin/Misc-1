// Time Complexity : O(n) : Traverse each element
// Space Complexity : O(n) : Stack

class Solution{

	int result;
	public int depthSum(List<NestedInteger> nestedlist){

		result = 0;

		// level / depth starts with 1.
		dfs(nestedlist, 1);

		return result;
	}

	private void dfs(List<NestedInteger> nestedlist , int depth){

		// Traverse through each character in nestedlist
		for (int i = 0; i < nestedlist.size() ; i++){

			// if integer
			if (nestedlist.get(i).isInteger()){

				// add the weighted sum into the result
				// getInteger() : will give integer in the nested list
				result += nestedlst.get(i).getInteger() * depth;

			}

			// if not integer
			else{

				// do dfs for next depth
				// getList() : will give the nested list
				dfs( nestedlist.get(i).getList(), depth + 1);
			}
		}


	}

}