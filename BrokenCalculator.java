class BrokenCalculator {
    
    // Time Complexity: O(logy)
    // Space Complexity: O(1)
    
    public int brokenCalc(int X, int Y) {
        if(X > Y)
            return X - Y;
        int count = 0;
        while(Y > X){
            if(Y % 2 == 0)
                Y = Y / 2;
            else
                Y++;
            count++;
        }
        return count + (X - Y);
    }
}