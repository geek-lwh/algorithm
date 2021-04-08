package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: luweihong
 * @Date: 2021/4/8
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class IsValid {

    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> parenthesesPopMapping = new HashMap<>();
        parenthesesPopMapping.put('(', ')');
        parenthesesPopMapping.put('[', ']');
        parenthesesPopMapping.put('{', '}');

        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char e = ch[i];
            if (parenthesesPopMapping.containsKey(e)) {
                stack.push(e);
                continue;
            }

            if(stack.isEmpty()){
                return false;
            }

            Character t = parenthesesPopMapping.get(e);
            if(!stack.peek().equals(t)){
                return false;
            }

            stack.pop();
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(solution(s));
    }
}
