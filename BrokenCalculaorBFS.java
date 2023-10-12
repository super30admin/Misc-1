import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
//Time limit exceeded
public class BrokenCalculaorBFS{

    public int brokenCalc(int startValue, int target) {
        if(startValue == 1 && target == 1) return 0;
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(startValue);
        set.add(startValue);
        int count = 0;
        while(!q.isEmpty()){
            count++;
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                int curr = q.poll();
                int ne = curr-1;

                if(curr>1)
                {
                    if(ne == target) return count;
                    if(!set.contains(ne)){
                        q.add(ne);
                    }
                }
                if(curr < target)
                {
                    ne = curr *2;
                    if(ne == target) return count;
                    if(!set.contains(ne)){
                        q.add(ne);
                    }
                }
            }

        }

        return count;
    }
}

