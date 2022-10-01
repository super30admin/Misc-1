// Time: O(log target)
// Space: O(1)


class Solution {
    public int brokenCalc(int startValue, int target) {
        int count = 0;
        while(target > startValue){
            if (target%2 == 1){
                count++;
                target++;
            }else{
                count++;
                target=target/2;
            }
        }
        return count+startValue-target;
    }
}



// Not executed (Time limit exceeded) using BFS
// DFS (didn't execute)

class Solution {
    public int brokenCalc(int startValue, int target) {
        Queue <Integer> q = new LinkedList<>();
        q.add(startValue);
        HashSet <Integer> set = new HashSet<>();
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int curr = q.poll();
                if (curr == target) return level;
                int mul = curr*2;
                int sub = curr-1;
                if (mul<target*2){
                    if (!set.contains(mul)){
                        q.add(mul);
                    }
                } 
                if (sub > 0){
                    if (!set.contains(sub)){
                        q.add(sub);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
