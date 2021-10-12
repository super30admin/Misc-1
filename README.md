# Misc-1

## Problem1: Calculate Using Broken Calculator (https://leetcode.com/problems/broken-calculator/)

// Time Complexity : O(logN) where N is targetvalue
// Space Complexity : O(1)

class Solution {
public int brokenCalc(int startValue, int target) {
if(startValue == target) {
return 0;
}
int steps = 0;

        while(target > startValue) {
            if(target % 2 == 0) {
                target = target / 2;
            } else {
                target = target + 1;
            }
            steps++;
        }

        return steps + startValue - target;
    }

}

## Problem2: Coin distribution(https://leetcode.com/problems/distribute-coins-in-binary-tree/)

// Time Complexity : O(N) where N is targetvalue
// Space Complexity : O(logN)

/\*\*

- Definition for a binary tree node.
- public class TreeNode {
-     int val;
-     TreeNode left;
-     TreeNode right;
-     TreeNode() {}
-     TreeNode(int val) { this.val = val; }
-     TreeNode(int val, TreeNode left, TreeNode right) {
-         this.val = val;
-         this.left = left;
-         this.right = right;
-     }
- }
  \*/
  class Solution {
  int extra = 0;
  int moves = 0;
  public int distributeCoins(TreeNode root) {
  if(root == null) {
  return 0;
  }
  int extra = dfs(root);

          return moves;
      }

      private int dfs(TreeNode root) {
          //base
          if(root == null) {
              return 0;
          }
          //logic
          int left = dfs(root.left);
          int right = dfs(root.right);
          extra = left + right + root.val - 1;
          moves += Math.abs(extra);
          return extra;
      }

  }

## Problem 3: Weight sum of a nested List (https://leetcode.com/problems/nested-list-weight-sum/)

// Time Complexity : O(N) : N is num of nested list
// Space Complexity : O(d) d : depth of list

class Solution {
public int depthSum(List<NestedInteger> nestedList) {
int result = 0;
Queue<NestedInteger> queue = new LinkedList<>();
int depth = 1;

        for(NestedInteger element : nestedList) {
            queue.add(element);
        }

        while(!queue.isEmpty()) {
            int sz = queue.size();
            for(int i = 0 ; i < sz; i++) {
                NestedInteger current = queue.poll();
                if(current.isInteger()) {
                    result += depth * current.getInteger();
                } else {
                    for(NestedInteger element : current.getList()) {
                        queue.add(element);
                    }
                }
            }
            depth++;
        }
        return result;
    }

}
