package sort;

/**
 * @Author: luweihong
 * @Date: 2021/4/16
 *
 * 表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。理论上讲，选择排序可能也是平时排序一般人想到的最多的排序方法了吧。
 *
 * 3、插入排序（Insertion Sort）
 * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 *
 * 3.1 算法描述
 * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
 *
 * 从第一个元素开始，该元素可以认为已经被排序；
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 将新元素插入到该位置后；
 * 重复步骤2~5。
 */
public class Insertion {

    // {7,8,3,5,4,1,6,5,9,12,15,54,24}
    public static int[] solution(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int swap = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = swap;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = ArrayFactory.forSort();
        ArrayFactory.print(solution(nums));
    }
}
