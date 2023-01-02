// Time Complexity: O(log(target))
// Space Complexity: O(1)
class Solution {
    public int brokenCalc(int startValue, int target) {
        if (startValue == target) return 0;

//         Queue<Integer> q = new LinkedList<>();
        int count = 0;
//         q.add(startValue);

//         // Do a BFS where the depth / count is the mininmum number of operations
//         // of finding the target
//         while(!q.isEmpty()) {
//             int size = q.size();
//             for (int i = 0; i < size; i++) {
//                 int curr = q.poll();
//                 if (curr * 2 == target) return count + 1;
//                 if (curr - 1 == target) return count + 1;
//                 // if (curr == target) {
//                 //     return count;
//                 // }
//                 if (curr > target) {
//                     if (curr > 0) {
//                         q.add(curr - 1);
//                     }

//                 } else {
//                     q.add(curr * 2);
//                     if (curr > 0) {
//                         q.add(curr - 1);
//                     }
//                 }
//             }
//             count++;
//         }

//         return 101007;

        while (target > startValue) {
            if (target % 2 == 0) {
                target = target / 2;
            } else {
                target = target + 1;
            }
            count++;
        }

        return count + startValue - target;
    }
}