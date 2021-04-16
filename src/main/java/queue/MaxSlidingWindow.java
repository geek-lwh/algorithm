package queue;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: luweihong
 * @Date: 2021/4/9
 *
 * 给你一个整数数组 nums，有一个大小为的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 *
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 *
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -10^4<= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 * 优先级队列遇到的是出队的问题,pop的不一定是按顺序的
 * 双端队列遇到的是排序问题,出入好用但是还要排序,排序就要全部出队.麻烦
 *
 */
public class MaxSlidingWindow {

    public static int[] solution(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        if (k > nums.length) {
            throw new IllegalArgumentException();
        }

//        for (int i = 0; i < k; i++) {
//            queue.addFirst(nums[i]);
//        }
//
        int[] r = new int[nums.length - k + 1];
        int m = nums[0];
        int j =0;
        for (int i = 0; i < nums.length; i++) {
            int c = nums[i];
            queue.addLast(c);

            m = Math.max(c, m);
            if(queue.size() > k){
                queue.removeFirst();
                // m 值的问题
                r[j++] = m;
            }
        }

        return r;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] nums = {1, -1};
//        int[] nums = {1};
//        int[] nums = {4,-2};
        int[] nums = {7,2,4};
        int k = 2;
        int[] r = solution(nums, k);

        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]);
        }
    }

}
