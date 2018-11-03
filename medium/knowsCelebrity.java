/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        
        // push all people onto the stack.
        for(int i = 0; i < n; i++)
            stack.push(i);
        
        // use a stack to compare the 2 top most elements.
        int a = 0;
        int b = 0;
        while(stack.size() > 1) {
            // pop and store the highest elements.
            a = stack.pop();
            b = stack.pop();
            
            // compare them:
            // if a knows b, then b is the celebrity.
            // else, b knows a, then a is the celebrity.
            // push that possible celebrity back onto the stack
            if(knows(a, b)) {
                stack.push(b);
            }
            else {
                stack.push(a);
            }
        }
        
        // now make sure that person doesn't know anyone.
        int celeb = stack.pop();
        for(int i = 0; i < n; i++) {
    if(i != celeb && (knows(celeb, i) || !knows(i, celeb))) {
                return -1;
            }
        }
        
        return celeb;
    }
}
