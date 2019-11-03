package data_structure;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    //括号匹配
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c== '{'){
                stack.push(c);
                continue;
            }
            if(stack.empty()){
                return false;
            }
            char top = stack.pop();
            if(top == '(' && c == ')'){
                continue;
            }
            if(top == '[' && c == ']'){
                continue;
            }
            if(top == '{' && c == '}'){
                continue;
            }
            return false;
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }
}
