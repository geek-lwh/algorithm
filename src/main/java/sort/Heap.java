package sort;

/**
 * @Author: luweihong
 * @Date: 2021/4/16
 * @See link  https://www.cnblogs.com/onepixel/articles/7674659.html
 * 堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
 *
 * 7.1 算法描述
 * 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 * 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
 * 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 */
public class Heap {

    public static int[] heapSort(int[] arr){
        int len = arr.length;

        // 构建一个无序大顶堆
        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            // 头和尾巴交换
            swap(arr, 0, i);
            len--;
            // 再构建堆
            heapify(arr, 0, len);
        }

        return arr;
    }



    /**
     * 构建堆的过程
     * @param arr 需要排序的数组
     * @param len 数组的长度
     */
    public static void buildMaxHeap(int[] arr, int len){
        // 为什么是从中间开始找 因为子节点是2*i +1/2
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        //左子树和根比
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        // 右子树和根比
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        // 确定子树比根大
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // 获取到左孩子结点
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    private static int rightChild(int i){
        return 2 * i + 2;
    }

    public static void main(String[] args) {
        int[] arr = ArrayFactory.newArray(51,24,55,66,78,89);
        heapSort(arr);
        ArrayFactory.print(arr);
    }
}
