package stack;

import java.util.Stack;

/**
 * @Author: luweihong
 * @Date: 2021/4/8
 *
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：
 * 要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用0 来代替。
 *
 * 例如，给定一个列表
 * temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是[1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是[1, 30000]。
 * 每个气温的值的均为华氏度，都是在[30, 100]范围内的整数。
 *
 *
 *
 */
public class DailyTemperatures {

    // 73, 74, 75, 71, 69, 72, 76, 73
    public static int[] solution(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = i + 1; j < arr.length; j++) {
                count++;
                if (arr[i] < arr[j]) {
                    result[i] = count;
                    break;
                }
            }

            if (count == 0) {
                result[i] = count;
            }
        }

        return result;
    }

    // 73, 74, 75, 71, 69, 72, 76, 73
    //找出数组中大于当前元素的第一个元素，到当前元素的距离
    //递减栈，当前元素与栈中元素比较，小则入栈，大则出栈并将二者之间的下标差值为出栈元素的结果值，并继续比较下一个栈顶元素
    //如果栈为空，直接入栈(表示前面元素都找到了比自己大的值)

    public static int[] solution2(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for(int i = 0; i < T.length; ++i){
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                int temp = stack.pop();
                res[temp] = i - temp;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution(temperatures);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
