// ## Problem1: Calculate Using Broken Calculator (https://leetcode.com/problems/broken-calculator/)

// TC: O(log(target))
// SC: O(1)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * @param {number} startValue
 * @param {number} target
 * @return {number}
 */
var brokenCalc = function (startValue, target) {
    let operations = 0;

    while (target > startValue) {
        if (target % 2 === 0) {
            // If target is even, divide by 2
            target = target / 2;
        } else {
            // Else add 1
            target = target + 1;
        }
        operations++;
    }
    // Only operations possible are adding
    return operations + (startValue - target);
};