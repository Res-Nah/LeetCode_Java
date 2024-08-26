/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if("+".equals(s)){
                stack.push(stack.pop() + stack.pop());
            }else if("-".equals(s)){
                stack.push(0 - stack.pop() + stack.pop());
            }else if("*".equals(s)){
                stack.push(stack.pop() * stack.pop());
            }else if("/".equals(s)){
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            }else{
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
// @lc code=end

