package list;

/**
 * @Author: luweihong
 * @Date: 2021/4/7
 *
 * 寻找链表倒数第k个元素
 *
 * 反转链表,然后循环
 * 1->2->3->4->5->NULL k=2
 * 4->5
 *
 * 快慢指针
 */
public class GetKthFromEnd {

    public static ListNode solution(ListNode head,int k){
        ListNode fast = head,slow = head;
        int c = 0;
        while (c++ < k){
            slow = slow.next;
        }

        while (slow != null){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    public static void main(String[] args) {
        ListNode result = solution(ListNode.simpleListNode(),2);
        ListNode.print(result);
    }

}
