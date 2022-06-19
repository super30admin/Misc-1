//Time Complexity: O(log n); where n = target.
//Space Complexity: O(1)

public class BrokenCalculator {	
    /**Approach2: Greedy**/	
	public int brokenCalc(int startValue, int target) {
        int count=0;
        while(target > startValue){
            if(target %2 == 0) 
                target = target/2;
            else{
                target = target+1;
            }
            count++;
        }  
        return count + (startValue-target);
    }
	
	/** Driver code to test above **/
	public static void main (String[] args) {			
		BrokenCalculator ob  = new BrokenCalculator();
		int startValue = 6;//2;//5;
		int target = 17;//3;//8;
								
		System.out.println("Min no. of operations to make "+target+" from "+startValue+" :"+ob.brokenCalc(startValue, target)); 
	}	
}
