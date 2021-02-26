// Time, Space -  O(N), O(N)
class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int[] leftSmall = new int[heights.length];
        int[] rightSmall = new int[heights.length];
        
        Stack<Integer> s = new Stack<>();
        leftSmall[0] = -1;
        s.push(0);
        // left small
        for(int i=1;i<heights.length;i++) {
            while(!s.isEmpty() && heights[i] <= heights[s.peek()]) {
                s.pop();                
            }
            if(s.isEmpty()) {
                leftSmall[i] = -1;
            }
            else {
                leftSmall[i] = s.peek();
            }
            s.push(i);
        }
        
        
        // right small
        s = new Stack<>();
        rightSmall[heights.length - 1] = heights.length;
        s.push(heights.length - 1);
        for(int i = heights.length - 2;i>=0;i--) {
            while(!s.isEmpty() && heights[i] <= heights[s.peek()]) {
                s.pop();                
            }
            if(s.isEmpty()) {
                rightSmall[i] = heights.length;
            }
            else {
                rightSmall[i] = s.peek();
            }            
            s.push(i);
        }
        
        int maxArea = 0;
        for(int i=0;i<heights.length;i++) {
            maxArea = Math.max((Math.abs(leftSmall[i] - rightSmall[i]) - 1) * heights[i], maxArea);
        }
        
        return maxArea;
    }
}
