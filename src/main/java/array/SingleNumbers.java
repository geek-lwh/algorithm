package array;

/**
 * @Author: luweihong
 * @Date: 2021/4/7
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 * 异或运算(^)是以二进制数据为基础进行运算的。也就是说当代码中使用到异或运算时，
 * 都会先将两个条件进行转换，转换成二进制数据后，再进行运算。异域中同位如果值相同(都是0或者都是1)则为0，不同(一个是0，一个是1)为1。
 *
 *
 * 首先要知道异或运算的几个性质:相同的数异或为0，不同的异或为1。0和任何数异或等于这个数本身。
 *
 * 交换律
 * 结合律（即(a^b)^c == a^(b^c)）
 * 对于任何数x，都有x^x=0，x^0=x
 * 自反性 A ^ B ^ B = A
 * 自反性 A ^ 0 = A
 * if A ^ B = C then C ^ B = A
 *
 */
public class SingleNumbers {
//
//    public static int[] solution(int[] nums){
//        int ans=0;
//        for(int i=0;i<nums.length;i++){
//            ans^=nums[i];   //异或运算
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        int c = 5;
        int d = 5;
        int e = 4;
        int f = 6;

        System.out.println(a ^ b ); // 不同的异或为1
        System.out.println(a ^ b ^ c ^ d ^ e ^ f); // 不同的异或为1
    }
}
