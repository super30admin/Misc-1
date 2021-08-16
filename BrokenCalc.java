class BrokenCalc {
    //time: O(log(target-startValue))
    //space: O(1)
    public int brokenCalc(int startValue, int target) {
        
        //initialize count
        int count=0;
        
        //until target is greater
        while(target>startValue){
            
            //if target divisible by 2
            if(target%2==0){
                //reduce target to hald
                target /= 2;
            }
            //if target not dicisible by 2
            else{
                //increase target by 1
                target += 1;
            }
            //update count
            count++;
        }
        //count and remaining difference between startvalue and target
        return count + startValue - target;
    }
	
	}