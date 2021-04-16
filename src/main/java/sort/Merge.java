package sort;

/**
 * @Author: luweihong
 * @Date: 2021/4/16
 *
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 *
 * 5.1 算法描述
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别采用归并排序；
 * 将两个排序好的子序列合并成一个最终的排序序列。
 */
public class Merge {

    // {1,2,3,4,5} length 13
    public static int[] solution(int[] nums, int[] temp, int left, int right) {
        System.out.println("left : " + left + ",right : " + right);
        if (left < right) {
            int mid = (left + right) / 2;
            solution(nums, temp, left, mid);
            solution(nums, temp, mid + 1, right);
            merge(nums, temp, left, mid + 1, right);
        }

        return nums;
    }

    // 合并2个有序数组
    public static void merge(int[] nums, int[] temp, int left, int mid, int right) {
        int tempIndex = left;
        int leftIndex = left;
        int leftEnd = mid - 1;
        int rightIndex = mid;
        int rightEnd = right;
        // todo
        int sortNumberCount = rightEnd - leftIndex + 1; // 元素个数

        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if (nums[leftIndex] <= nums[rightIndex]) {
                temp[tempIndex++] = nums[leftIndex++];
            } else {
                temp[tempIndex++] = nums[rightIndex++];
            }
        }

        // 左边如果有剩余
        while (leftIndex <= leftEnd) {
            temp[tempIndex++] = nums[leftIndex++];
        }
        // 右边如果有剩余
        while (rightIndex <= rightEnd) {
            temp[tempIndex++] = nums[rightIndex++];
        }

        // 将temp复制到arr
        for (int i = 0; i < sortNumberCount; i++) {
            nums[rightEnd] = temp[rightEnd];
            rightEnd--;
        }

        ArrayFactory.print(nums);

    }

    // new int[]{7,8,3,5,1,6,5,9,12,15,54,24,4,77,33,11,23,45,66,1};
    public static void main(String[] args) {
        int[] nums = ArrayFactory.newArray(5, 4, 3, 2, 1);
        int left = 0;
        int right = nums.length - 1;
        int[] temp = new int[nums.length];
        ArrayFactory.print(solution(nums, temp, left, right));
    }
}
