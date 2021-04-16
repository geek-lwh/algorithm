package sort;

/**
 * @Author: luweihong
 * @Date: 2021/4/16
 *
 * 将2个有序数组 合并到1个
 */
public class Merge2 {

    public static void sort(int[] a, int[] b, int[] c, int aLength, int bLength) {
        int aIndex = 0, bIndex = 0, cIndex = 0;
        while (aIndex < aLength && bIndex < bLength) {
            if (a[aIndex] <= b[bIndex]) {
                c[cIndex++] = a[aIndex++];
            } else {
                c[cIndex++] = b[bIndex++];
            }
        }

        while (aIndex < aLength){
            c[cIndex++] = a[aIndex++];
        }

        // 把剩下的b 全部放进去,假设B是排序的话就可以这么做
        while (bIndex < bLength){
            c[cIndex++] = b[bIndex++];
        }

        ArrayFactory.print(c);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6};
        int[] b = new int[]{1, 7, 8, 9};
        int[] c = new int[a.length + b.length];
        sort(a, b, c, a.length, b.length);

    }

}
