package list;

/**
 * @Author: luweihong
 * @Date: 2021/4/7
 *
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 *
 * 给定的 k 保证是有效的。
 *
 */
public class KthToLast {

    public static int solution(ListNode head,int k){
        ListNode fast = head,slow = head;
        int c = 0;
        while (c++ < k){
            fast = fast.next;
        }

        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow.val;
    }

    public static void main(String[] args) {
      System.out.println(solution(ListNode.simpleListNode(),2));
    }
}
