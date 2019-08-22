class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String token : tokens) {
            if(token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {
                // do math
                int num1 = stack.pop();
                int num2 = stack.pop();
                
                int ans = computer(token, num2, num1);
                stack.push(ans);
            }
            else {
                stack.push(Integer.parseInt(token));
            }   
        }
        
        // System.out.println("hello " + stack.peek());
        return stack.peek();
    }
    
    public int computer(String op, int num1, int num2) {
        if(op.equals("+")) {
            return num1 + num2;
        }
        if(op.equals("/")) {
            return num1 / num2;
        }
        if(op.equals("-")) {
            return num1 - num2;
        }
        
        return num1 * num2;
    }
}

/*
["-78","-33","196","+","-19","-","115","+","-","-99","/","-18","8","*","-86","-","-","16","/","26","-14","-","-","47","-","101","-","163","*","143","-","0","-","171","+","120","*","-60","+","156","/","173","/","-24","11","+","21","/","*","44","*","180","70","-40","-","*","86","132","-84","+","*","-","38","/","/","21","28","/","+","83","/","-31","156","-","+","28","/","95","-","120","+","8","*","90","-","-94","*","-73","/","-62","/","93","*","196","-","-59","+","187","-","143","/","-79","-89","+","-"]
*/
