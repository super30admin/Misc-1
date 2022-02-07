// Time Complexity : O(n) : Traverse each element
// Space Complexity : O(n) : Queue


class Solution{

	public int depthSum(List<NestedInteger> nestedlist){

		int level = 1;
		int result = 0;

		Queue<NestedInteger> queue = new LinkedList<>();


		// add all the elements as they belong to the level-1
		for (int i = 0 ; i < nestedlist.size(); i++){

			queue.add(nestedlist.get(i));
		}

		while(!queue.isEmpty()){

			int size =  queue.size();

			// pop the element
			NestedInteger curr = queue.poll();

			// curr can be a integer 

			if (curr.isInteger()){
				// weighted sum
				result += curr.getInteger() * level;
			}

			// curr can be a nested list
			else{

				List<NestedInteger> list = curr.getList();
				// add all the elements into the next level

				for (int j =0 ; j < list.size(); i++){

					queue.add(list.get(j));
				}
			}

			// increase the level 
			level++;

		}

		return result;
	}

}