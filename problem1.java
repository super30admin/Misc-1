import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class problem1 {

    //using /, and +
// Time Complexity:O(logn)+O(K )
    public int brokenCalc2(int startValue, int target) {
        int count = 0;
        while (target > startValue) {
            if (target%2==0)
            {
                target = target/2;
            }
            else {
                target= target+1;
            }
            count++;
        }
        return count +(startValue-target);
    }

    //bfs, tle
    public int brokenCalc1(int startValue, int target) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(startValue);

        HashSet<Integer> set= new HashSet<>();
        set.add(startValue);
        int steps=0;
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size;i++){
                int curr= q.poll();
                if (curr == target){
                    return steps;
                }
                if (curr<target){
                    int ne= curr*2;
                    if (!set.contains(ne)){
                        set.add(ne);
                        q.add(ne);
                    }
                }
                if (curr>1)
                {
                    int ne= curr-1;
                    if (!set.contains(ne)){
                        set.add(ne);
                        q.add(ne);
                    }

                }
            }
            steps++;
        }
        return -1;
    }
}
