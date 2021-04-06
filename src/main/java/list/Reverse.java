package list;

/**
 * @Author: luweihong
 * @Date: 2021/4/6
 * 链表翻转
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Reverse {


    public static ListNode reverseList(ListNode head) {
        ListNode reverse = null;
        while (head != null){
            ListNode newHead = new ListNode(head.val);
            newHead.next = reverse;
            reverse = newHead;
            head = head.next;
        }

        return reverse;
    }

    public static void main(String[] args) {
        reverseList(ListNode.simpleListNode());
    }

}

